//
//  ExploreScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shuffle

struct ExploreScreen: View {
    var body: some View {
        VStack {
            SwipeCardView()
            ReactionsBar()
        }.padding(.vertical, 32)
    }
}

#Preview {
    ExploreScreen()
}
