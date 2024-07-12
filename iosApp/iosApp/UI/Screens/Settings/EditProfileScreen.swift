//
//  EditProfileScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 25/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

struct EditProfileScreen: View {
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        if let profile = (viewModel.state as? ProfileUiStateSuccess)?.profile {
            NavigationStack {
                ScrollView {
                    Text("About you")
                        .padding(.horizontal, 12)
                        .padding(.vertical, 2)
                        .font(Font.custom("BRSonoma-SemiBold", size: 14))
                        .frame(maxWidth: .infinity, alignment: .leading)
                    NavigationLink(destination: EditNameScreen()){
                        SettingField(fieldName: "Prénom", field: profile.displayName)
                    }
                    NavigationLink(destination: EditBiographyScreen()){
                        SettingField(fieldName: "Biographie", field: profile.biography)
                    }
                    SettingField(fieldName: "Taille", field: "1m89")
                    SettingField(fieldName: "Origines", field: "France, Maroc")
                    SettingField(fieldName: "Langues", field: "Darija (marocain), Français")
                    SettingField(fieldName: "Centres d'interets", field: "Football, Danse, Karaté")
                }.toolbar {
                    ToolbarItem(placement: .principal) {
                        Text("Edit your profile")
                            .font(Font.custom("BRSonoma-SemiBold", size: 15))
                    }
                }
                .onAppear {
                    viewModel.startObserving()
                }
                .onDisappear {
                    viewModel.stopObserving()
                }
            }
        }
    }
}

extension EditProfileScreen {
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
    EditProfileScreen()
}

