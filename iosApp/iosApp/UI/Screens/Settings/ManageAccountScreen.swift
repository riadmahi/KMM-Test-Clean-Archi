//
//  ManageAccountScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 12/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

struct ManageAccountScreen: View {
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        if let profile = (viewModel.state as? ProfileUiStateSuccess)?.profile {
            NavigationStack {
                ScrollView {
                    Text("Connexion")
                        .padding(.horizontal, 12)
                        .padding(.vertical, 2)
                        .font(Font.custom("BRSonoma-SemiBold", size: 14))
                        .frame(maxWidth: .infinity, alignment: .leading)
                    Button {
                        viewModel.logout()
                    } label: {
                        SettingField(fieldName: "Sign out", field: "Je souhaite me déconnecter")
                    }
                }.toolbar {
                    ToolbarItem(placement: .principal) {
                        Text("Manage your account")
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

extension ManageAccountScreen {
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
        
        func logout() {
            repository.logout()
        }
    }
}


#Preview {
    ManageAccountScreen()
}

