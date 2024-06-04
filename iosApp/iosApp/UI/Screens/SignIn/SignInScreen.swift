//
//  SignInScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SignInScreen: View {
    @State private var email: String = ""
    
    @State private var password: String = ""
    
    var body: some View {
        VStack(spacing: 42) {
            Text("Heureux de vous revoir! 👋")
                .font(Font.custom("BRSonoma-SemiBold", size: 24))
                .frame(maxWidth: .infinity, alignment: .leading)
            VStack(spacing: 24) {
                TextField(
                    "Email",
                    text: $email
                )
                .padding(.vertical, 18)
                .padding(.horizontal, 16)
                .background(Color("SecondBgColor"))
                .textInputAutocapitalization(.never)
                .clipShape(RoundedRectangle(cornerRadius: 8))
                .font(Font.custom("BRSonoma-Regular", size: 16))
                .accentColor(Color("AccentColor"))

                
                TextField(
                    "Password",
                    text: $email
                )
                .padding(.vertical, 18)
                .padding(.horizontal, 16)
                .background(Color("SecondBgColor"))
                .textInputAutocapitalization(.never)
                .clipShape(RoundedRectangle(cornerRadius: 8))
                .font(Font.custom("BRSonoma-Regular", size: 16))
                .accentColor(Color("AccentColor"))

                
                Text("Forgot your password?").frame(maxWidth: .infinity, alignment: .trailing)                        .font(Font.custom("BRSonoma-Regular", size: 14))
                    .foregroundColor(Color("PlaceholderColor"))
                
            }
            HobButton(text: "Sign in", width: UIScreen.main.bounds.width - 32) {
                
            }
            Spacer()
        }.frame(maxWidth: .infinity, alignment: .leading)
            .padding(.horizontal, 24)
            .padding(.vertical, 32)
        
        
    }
}

#Preview {
    SignInScreen()
}
