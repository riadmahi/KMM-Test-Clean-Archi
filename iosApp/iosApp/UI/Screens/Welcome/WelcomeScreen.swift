//
//  WelcomeScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct WelcomeScreen: View {
    @State private var navigateToSignIn = false
    @State private var navigateToSignUp = false
    
    var body: some View {
        NavigationStack {
            ZStack {
                Image("bg_welcome")
                    .resizable() // Ensure the image can be resized
                    .frame(width: UIScreen.main.bounds.width, height: UIScreen.main.bounds.height) // Fill the entire screen
                    .edgesIgnoringSafeArea(.all)
                VStack(spacing: 16) {
                    Image("ic_brand")
                    Spacer()
                    Text("L’app.")
                        .font(Font.custom("BRSonoma-Bold", size: 32))
                        .foregroundColor(.white)
                        .frame(width: UIScreen.main.bounds.width - 32, alignment: .leading)
                        .padding(.bottom, 18)
                    
                    
                    HobButton(text: "Sign in", width: UIScreen.main.bounds.width - 32) {
                        navigateToSignIn = true
                    }
                    .navigationDestination(
                        isPresented: $navigateToSignIn,
                        destination: { SignInScreen()}
                    )

                    DarkHobButton(text: "Sign up", width: UIScreen.main.bounds.width - 32) {
                        navigateToSignUp = true
                    }
                    .navigationDestination(
                        isPresented: $navigateToSignUp,
                        destination: { SignUpScreen()}
                    )
                }.padding(.vertical, 60)
            }
        }
        .accentColor(Color("AccentColor"))
    }
}


#Preview {
    WelcomeScreen()
}

