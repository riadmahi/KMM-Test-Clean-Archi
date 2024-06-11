//
//  ProfileScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ProfileScreen: View {
    @StateObject private var viewModel = ViewModel()
    var body: some View {
        ScrollView {
            if let profile = viewModel.profile {
                ProfileHeader(photoUrl: "https://plus.unsplash.com/premium_photo-1675107360237-22fa96b9995b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHx8fA%3D%3D",
                              name: profile.displayName)
                ProfileContent()
            }
            
        }
    }
}


struct ProfileContent: View {
    var body: some View {
        VStack {
            PremiumCard()
            ProfileActionCard(actionName: "Edit your profile")
            Divider().padding(.horizontal, 24)
            ProfileActionCard(actionName: "Manage my account")
            Divider().padding(.horizontal, 24)
            ProfileActionCard(actionName: "App settings")
            Divider().padding(.horizontal, 24)
            ProfileActionCard(actionName: "Contact support")
        }
    }
}

extension ProfileScreen {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var profile: Profile?
        private var repository: HobRepository
        
        init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
            self.repository = repository
            if let profileState = repository.profileUiState as? ProfileUiStateSuccess {
                self.profile = profileState.profile
            }
        }
    }
}


#Preview {
    ProfileScreen()
}
