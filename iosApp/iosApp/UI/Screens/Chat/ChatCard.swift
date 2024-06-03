//
//  ChatCard.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ChatCard: View {
    var photoUrl: String
    var name: String
    var lastMessage: String
    
    var body: some View {
        HStack(spacing: 12) {
            AsyncImage(url: URL(string: photoUrl)){ result in
                result.image?
                    .resizable()
                    .scaledToFill()
            }
            .frame(width: 65, height: 65)
            .clipShape(Circle())
            
            VStack(alignment: .leading, spacing: 6) {
                Text(name)
                    .font(Font.custom("BRSonoma-SemiBold", size: 18))
                Text(lastMessage)
                    .font(Font.custom("BRSonoma-Regular", size: 17))
                    .foregroundColor(Color("PlaceholderColor"))
                    .frame(maxWidth: .infinity, alignment: .leading)
            }
            .frame(maxWidth: .infinity, alignment: .leading)
        }
        .padding(.vertical, 6)
        .padding(.horizontal, 16)
    }
}
