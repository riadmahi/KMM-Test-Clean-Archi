//
//  SignUpScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 04/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SignUpScreen:  View {
    @State private var email: String = ""
    @State private var password: String = ""
    @State var isPasswordVisible: Bool = false
    
    var body: some View {
        VStack(spacing: 42) {
            Text("Créer ton compte 👋")
                .font(Font.custom("BRSonoma-SemiBold", size: 24))
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 24) {
                HobTextField(hint: "Email", text: $email)
                SecureHobTextField(
                    hint: "Password",
                    password: $password,
                    isPasswordVisible: $isPasswordVisible
                )
            }
            HobButton(text: "Sign up", width: UIScreen.main.bounds.width - 32) {
                
            }
            Spacer()
        }.frame(maxWidth: .infinity, alignment: .leading)
            .padding(.horizontal, 24)
            .padding(.vertical, 32)
        
    }
}

#Preview {
    SignUpScreen()
}
