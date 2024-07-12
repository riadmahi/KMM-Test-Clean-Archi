//
//  EditBiographyScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 12/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

struct EditBiographyScreen: View {
    @Environment(\.presentationMode) var presentationMode
    @StateObject private var viewModel = ViewModel()
    @State private var biography: String = ""
    
    var body: some View {
        if var profile = (viewModel.state as? ProfileUiStateSuccess)?.profile {
            ScrollView {
                HobTextField(hint: "Biography", text: $biography).padding(.horizontal, 12).padding(.vertical, 24)
            }.toolbar {
                ToolbarItem(placement: .principal) {
                    Text("Edit your biography")
                        .font(Font.custom("BRSonoma-SemiBold", size: 15))
                }
                ToolbarItem(placement: .confirmationAction) {
                    Button {
                        viewModel.updateBiography(newBio: biography)
                        self.presentationMode.wrappedValue.dismiss()
                    } label: {
                        Text("OK")
                            .font(Font.custom("BRSonoma-SemiBold", size: 13))
                            .foregroundColor(Color("AccentColor"))
                    }
                }
            }.onAppear {
                biography = profile.biography
            }
        }
    }
}



extension EditBiographyScreen {
    @MainActor
    class ViewModel: ObservableObject {
        private var repository: HobRepository
        @Published public var state: ProfileUiState =  ProfileUiStateNone()
        
        init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
            self.repository = repository
            self.state = repository.profileUiState
        }
        
        func updateBiography(newBio: String) {
            Task {
                guard var profile = (state as? ProfileUiStateSuccess)?.profile else { return }
                profile.biography = newBio
                do {
                    try await repository.updateProfile(profile: profile)
                    // Update state after successful profile update
                    DispatchQueue.main.async {
                        self.state = ProfileUiStateSuccess(profile: profile)
                    }
                } catch {
                    // Handle error
                    print("Failed to update profile: \(error)")
                }
            }
        }
    }
}


