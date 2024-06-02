//
//  ReactionsBar.swift
//  iosApp
//
//  Created by Riad MAHI on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ReactionsBar: View {
    var body: some View {
        HStack(spacing: 24) {
            Button {
                
            } label: {
                Image("ic_rollback")
                    .foregroundColor(.white)
                    .shadow(radius: 5)
                    .padding(12)
                    .background(        
                        LinearGradient(gradient: Gradient(colors: [Color(hex:0x7FFF43), Color(hex: 0x31DD4D)]), startPoint: .top, endPoint: .bottom)
                    )
                    .overlay(
                        Circle().stroke().tint(Color.white)
                    )
                    .clipShape(Circle())
            }
            Button {
                
            } label: {
                Image("ic_next")
                    .foregroundColor(.white)
                    .shadow(radius: 5)
                    .padding(12)
                    .background(
                        LinearGradient(gradient: Gradient(colors: [Color(hex:0xDED6E5), Color(hex: 0x7B777F)]), startPoint: .top, endPoint: .bottom)
                    )
                    .overlay(
                        Circle().stroke().tint(Color.white)
                    )
                    .clipShape(Circle())
            }
            Button {
                
            } label: {
                Image("ic_super_like")
                    .foregroundColor(.white)
                    .shadow(radius: 5)
                    .padding(15)
                    .background(
                        LinearGradient(gradient: Gradient(colors: [Color(hex:0xCEFF43), Color(hex: 0xFFCC19)]), startPoint: .top, endPoint: .bottom)
                    )
                    .overlay(
                        Circle().stroke().tint(Color.white)
                    )
                    .clipShape(Circle())
            }
            Button {
                
            } label: {
                Image("ic_like")
                    .foregroundColor(.white)
                    .shadow(radius: 5)
                    .padding(12)
                    .background(
                        LinearGradient(gradient: Gradient(colors: [Color(hex:0xAF4BFF), Color(hex: 0xEA75C2)]), startPoint: .top, endPoint: .bottom)
                    )
                    .overlay(
                        Circle().stroke().tint(Color.white)
                    )
                    .clipShape(Circle())
            }
        }
    }
}

#Preview {
    ReactionsBar()
}
