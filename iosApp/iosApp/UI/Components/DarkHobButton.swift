//
//  DarkHobButton.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DarkHobButton: View {
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
                .background(Color(hex: 0x3B3B3B))
                .clipShape(RoundedRectangle(cornerRadius: 50))
                .font(Font.custom("BRSonoma-SemiBold", size: 16))
            }
    }
}


#Preview {
    DarkHobButton(text: "Hello", width: 250)
}

