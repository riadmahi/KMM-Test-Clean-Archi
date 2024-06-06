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
                
                if isPasswordVisible {
                    TextField(
                        "Password",
                        text: $password
                    )
                    .padding(.vertical, 18)
                    .padding(.horizontal, 16)
                    .background(Color("SecondBgColor"))
                    .textInputAutocapitalization(.never)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                    .font(Font.custom("BRSonoma-Regular", size: 16))
                    .accentColor(Color("AccentColor"))
                    .overlay(alignment: .trailing) {
                        Image(systemName: isPasswordVisible ? "eye.fill" : "eye.slash.fill")
                            .padding()
                            .onTapGesture {
                                isPasswordVisible.toggle()
                            }
                    }
                } else {
                    SecureField(
                        "Password",
                        text: $password
                    )
                    .padding(.vertical, 18)
                    .padding(.horizontal, 16)
                    .background(Color("SecondBgColor"))
                    .textInputAutocapitalization(.never)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                    .font(Font.custom("BRSonoma-Regular", size: 16))
                    .accentColor(Color("AccentColor"))
                    .overlay(alignment: .trailing) {
                        Image(systemName: isPasswordVisible ? "eye.fill" : "eye.slash.fill")
                            .padding()
                            .onTapGesture {
                                isPasswordVisible.toggle()
                            }
                    }
                }
                
                
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
