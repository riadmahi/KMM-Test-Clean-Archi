//
//  File.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HobButton: View {
    var text: String
    var width: CGFloat? = nil
    var body: some View {
        Button {
            
        } label: {
            Text(text)
                .foregroundColor(.white)
                .padding(.horizontal, 32)
                .padding(.vertical, 16)
                .frame(width: width)
                .background(
                    LinearGradient(gradient: Gradient(colors: [Color(hex:0xAA5CE8), Color(hex: 0xDD2F9E)]), startPoint: .bottomLeading, endPoint: .topTrailing)
                )
                .clipShape(RoundedRectangle(cornerRadius: 50))
                .font(Font.custom("BRSonoma-SemiBold", size: 16))
            }
    }
}


#Preview {
    HobButton(text: "Hello", width: 250)
}
