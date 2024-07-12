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
        if let profile = (viewModel.state as? ProfileUiStateSuccess)?.profile {
            NavigationStack {
                ScrollView {
                    ProfileHeader(photoUrl: "https://plus.unsplash.com/premium_photo-1675107360237-22fa96b9995b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHx8fA%3D%3D",
                                  name: profile.displayName)
                    ProfileContent()
                }
            }.onAppear {
                viewModel.startObserving()
            }
            .onDisappear {
                viewModel.stopObserving()
            }
        }
    }
}


struct ProfileContent: View {
    var body: some View {
        PremiumCard()
        NavigationLink(destination: EditProfileScreen()){
            ProfileActionCard(actionName: "Edit your profile")
        }
        Divider().padding(.horizontal, 24)
        NavigationLink(destination: ManageAccountScreen()){
            ProfileActionCard(actionName: "Manage your account")
        }
        Divider().padding(.horizontal, 24)
        ProfileActionCard(actionName: "App settings")
        Divider().padding(.horizontal, 24)
        ProfileActionCard(actionName: "Contact support")
    }
}

extension ProfileScreen {
    @MainActor
    class ViewModel: ObservableObject {
        private var repository: HobRepository
        @Published public var state: ProfileUiState =  ProfileUiStateNone()
        private var cancellables = Set<AnyCancellable>()
        
        init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
            self.repository = repository
            self.state = repository.profileUiState
        }
        
        func startObserving() {
            RepositoryProvider.shared.$profileUiState
                .receive(on: DispatchQueue.main)
                .sink { [weak self] newState in
                    self?.state = newState
                }
                .store(in: &cancellables)
        }
        
        func stopObserving() {
            cancellables.removeAll()
        }
    }
}


#Preview {
    ProfileScreen()
}
