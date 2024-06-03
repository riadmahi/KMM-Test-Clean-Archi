//
//  GoldButton.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct PremiumButton: View {
    var text: String
    var body: some View {
        Button {
            
        } label: {
            Text(text)
                .foregroundColor(.white)
                .shadow(radius: 5)
                .padding(.horizontal, 24)
                .padding(.vertical, 12)
                .background(
                    LinearGradient(gradient: Gradient(colors: [Color(hex:0xF5BA54), Color(hex: 0xF5CD40), Color(hex: 0xF5BA54), Color(hex: 0xC89743)]), startPoint: .leading, endPoint: .trailing)
                )
                .clipShape(RoundedRectangle(cornerRadius: 50))
                .font(Font.custom("BRSonoma-SemiBold", size: 16))
            }
    }
}


#Preview {
    PremiumButton(text: "Premium")
}
