//
//  ProfileScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Combine
import shared
import KMPNativeCoroutinesCombine

struct ProfileScreen: View {
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        NavigationStack {
            
            ScrollView {
                if let profile = (viewModel.state as? ProfileUiStateSuccess)?.profile {
                    ProfileHeader(photoUrl: "https://plus.unsplash.com/premium_photo-1675107360237-22fa96b9995b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHx8fA%3D%3D",
                                  name: profile.displayName)
                    ProfileContent()
                }
                
            }
        }
    }
}


struct ProfileContent: View {
    @State private var navigateToEditProfile = false
    
    var body: some View {
        PremiumCard()
        ProfileActionCard(actionName: "Edit your profile") {
            navigateToEditProfile = true
        } .navigationDestination(
            isPresented: $navigateToEditProfile,
            destination: { EditProfileScreen()}
        )
        Divider().padding(.horizontal, 24)
        ProfileActionCard(actionName: "Manage my account") { }
        Divider().padding(.horizontal, 24)
        ProfileActionCard(actionName: "App settings"){ }
        Divider().padding(.horizontal, 24)
        ProfileActionCard(actionName: "Contact support"){ }
    }
}

extension ProfileScreen {
    @MainActor
    class ViewModel: ObservableObject {
        private var repository: HobRepository
        private var cancellables = Set<AnyCancellable>()
        @Published public var state: ProfileUiState =  ProfileUiStateNone()
        
        init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
            self.repository = repository
            // Create an AnyPublisher for your flow
            
            let publisher = createPublisher(for: repository.profileUiStateFlow)
            publisher
                .receive(on: DispatchQueue.main)
                .sink(receiveCompletion: { completion in
                    switch completion {
                    case .finished:
                        // Handle successful completion (optional)
                        break
                    case .failure(let error):
                        // Handle error
                        print("Error received: \(error)")
                    }
                }, receiveValue: { [weak self] newState in
                    print(newState)
                    self?.state = newState
                })
                .store(in: &cancellables)
        }
        
        
        
    }
}


#Preview {
    ProfileScreen()
}
