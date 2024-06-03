//
//  WelcomeScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct WelcomeScreen: View {
    var body: some View {
        ZStack {
            Image("bg_welcome")
                .resizable() // Ensure the image can be resized
                .frame(width: UIScreen.main.bounds.width, height: UIScreen.main.bounds.height) // Fill the entire screen
                .edgesIgnoringSafeArea(.all) 
            VStack(spacing: 16) {
                Spacer()
                Text("L’app muslim pour trouver sa moitiée")
                    .font(Font.custom("BRSonoma-Bold", size: 32))
                    .foregroundColor(.white)
                    .frame(width: UIScreen.main.bounds.width - 32, alignment: .leading)
                    .padding(.bottom, 18)
                HobButton(text: "Sign in", width: UIScreen.main.bounds.width - 32)
                DarkHobButton(text: "Sign up", width: UIScreen.main.bounds.width - 32)

            }.padding(.vertical, 60)

        }
    }
}

#Preview {
    WelcomeScreen()
}

