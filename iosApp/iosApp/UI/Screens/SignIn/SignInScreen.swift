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
    @State var isPasswordVisible: Bool = false

    var body: some View {
        VStack(spacing: 42) {
            Text("Heureux de vous revoir! 👋")
                .font(Font.custom("BRSonoma-SemiBold", size: 24))
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 24) {
                HobTextField(hint: "Email", text: $email)
                SecureHobTextField(
                    hint: "Password",
                    password: $password,
                    isPasswordVisible: $isPasswordVisible
                )
                
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
