//
//  EditProfileScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 25/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct EditProfileScreen: View {
    @StateObject private var viewModel = ViewModel()
    var body: some View {
        if let profile = (viewModel.state as? ProfileUiStateSuccess)?.profile {
            ScrollView {
            Text("About you")
                .padding(.horizontal, 28)
                .padding(.vertical, 2)
                .font(Font.custom("BRSonoma-SemiBold", size: 15))
                .frame(maxWidth: .infinity, alignment: .leading)
                SettingField(fieldName: "Prénom", field: profile.displayName)
                SettingField(fieldName: "Biographie", field: profile.biography)
            SettingField(fieldName: "Taille", field: "1m89")
            SettingField(fieldName: "Origines", field: "France, Maroc")
            SettingField(fieldName: "Langues", field: "Darija (marocain), Français")
            SettingField(fieldName: "Centres d'interets", field: "Football, Danse, Karaté")
        }
    }
    }
}

extension EditProfileScreen {
    @MainActor
    class ViewModel: ObservableObject {
        private var repository: HobRepository
        @Published public var state: ProfileUiState =  ProfileUiStateNone()
        
        init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
            self.repository = repository
            self.state = repository.profileUiState
        }
    }
}


#Preview {
    EditProfileScreen()
}

