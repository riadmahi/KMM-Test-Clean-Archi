//
//  ProfileScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ProfileScreen: View {
    var body: some View {
        ScrollView {
            ProfileHeader(photoUrl: "https://plus.unsplash.com/premium_photo-1675107360237-22fa96b9995b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHx8fA%3D%3D",
                name: "Anna")
            ProfileContent()
        
        }
    }
}

struct ProfileHeader: View {
    var photoUrl: String
    var name: String
    var body: some View {
        VStack {
            AsyncImage(url: URL(string: photoUrl)){ result in
                result.image?
                    .resizable()
                    .scaledToFill()
                    .clipShape(Circle())
                    .frame(width: 120, height: 120)
            }
            Text(name)
                .font(Font.custom("BRSonoma-SemiBold", size: 18))
        }.padding(.vertical, 24)
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

struct ProfileActionCard: View {
    var actionName: String
    var body: some View {
        HStack {
            Text(actionName)
                .font(Font.custom("BRSonoma-Medium", size: 18))
                .frame(width: .infinity, alignment: .leading)
            Spacer()
            Image("ic_arrow_right")
                .frame(width: 32, height: 32)
        }.frame(maxWidth: .infinity, alignment: .leading)
            .padding(.horizontal, 24)
            .padding(.vertical, 8)
    }
}

#Preview {
    ProfileScreen()
}
