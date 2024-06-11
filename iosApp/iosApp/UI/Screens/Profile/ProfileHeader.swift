//
//  ProfileHeader.swift
//  iosApp
//
//  Created by Riad MAHI on 11/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ProfileHeader: View {
    var photoUrl: String
    var name: String
    var body: some View {
        VStack {
            AsyncImage(url: URL(string: photoUrl)){ result in
                result.image?
                    .resizable()
                    .scaledToFill()
                    .clipShape(Circle())
                    .frame(width: 120, height: 120)
            }
            Text(name)
                .font(Font.custom("BRSonoma-SemiBold", size: 18))
        }.padding(.vertical, 24)
    }
}
