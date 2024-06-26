//
//  ProfileActionCard.swift
//  iosApp
//
//  Created by Riad MAHI on 11/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ProfileActionCard: View {
    var actionName: String
    
    var body: some View {
            HStack {
                Text(actionName)
                    .font(Font.custom("BRSonoma-Medium", size: 16))
                    .frame(maxWidth: .infinity, alignment: .leading)
                Spacer()
                Image("ic_arrow_right")
                    .frame(width: 32, height: 32)
            }.frame(maxWidth: .infinity, alignment: .leading)
                .padding(.horizontal, 24)
            .padding(.vertical, 8)
    }
}

#Preview {
    ProfileActionCard(actionName: "Hello")
}
