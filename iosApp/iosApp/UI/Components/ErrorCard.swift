//
//  ErrorCard.swift
//  iosApp
//
//  Created by Riad MAHI on 10/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ErrorCard: View {
    var error: String
    var body: some View {
        HStack {
            Text(error).frame(maxWidth: .infinity, alignment: .leading)
                .font(Font.custom("BRSonoma-SemiBold", size: 16))
                .foregroundColor(.white)
                .padding(.horizontal, 24)
            
        }
        .padding(.vertical, 12)
        .background(Color(hex: 0xEC3446))
        .cornerRadius(8)

    }
}

#Preview {
    ErrorCard(error: "Erreur de composition")
}

