//
//  PremiumCard.swift
//  iosApp
//
//  Created by Riad MAHI on 11/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct PremiumCard: View {
    var body: some View {
        ZStack {
            Image("illustration_profile_premium").padding(.bottom, 24)
            VStack {
                    Spacer()  // Ajoute un espace flexible pour pousser le bouton vers le bas
                    PremiumButton(text: "Upgrade")
                }
        }.padding(.bottom, 32)
    }
}
