//
//  EditProfileScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 25/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct EditProfileScreen: View {
    var body: some View {
        ScrollView {
            Text("About you")
                .padding(.horizontal, 32)
                .padding(.vertical, 2)
                .font(Font.custom("BRSonoma-SemiBold", size: 16))
                .frame(maxWidth: .infinity, alignment: .leading)
            
            SettingField(fieldName: "Prénom", field: "Riad")
            SettingField(fieldName: "Biographie", field: "J'aime les fleurs")
            SettingField(fieldName: "Taille", field: "1m89")
            SettingField(fieldName: "Origines", field: "France, Maroc")
            SettingField(fieldName: "Langues", field: "Darija (marocain), Français")
            SettingField(fieldName: "Centres d'interets", field: "Football, Danse, Karaté")
        }
    }
}

#Preview {
    EditProfileScreen()
}

