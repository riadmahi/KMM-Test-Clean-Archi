//
//  HobTabView.swift
//  iosApp
//
//  Created by Riad MAHI on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HobTabView: View {
    init() {
        UITabBar.appearance().unselectedItemTintColor = UIColor(named: "PlaceholderColor")
        UITabBarItem.appearance().setTitleTextAttributes([NSAttributedString.Key.font: UIFont.init(name: "BRSonoma-SemiBold", size: 13)! ], for: .normal)
    }
    var body: some View {
        TabView {
            ExploreScreen()
                .tabItem {
                    Image("ic_explore")
                        .renderingMode(.template)
                    Text("Explore")
            }
            LikesScreen()
                .tabItem {
                    Image("ic_likes")
                        .renderingMode(.template)
                    Text("Likes")
            }
            ChatScreen()
                .tabItem {
                    Image("ic_chat")
                        .renderingMode(.template)
                    Text("Chat")

            }
            ProfileScreen()
                .tabItem {
                    Image("ic_profile")
                        .renderingMode(.template)
                    Text("Profile")
                
            }
        }.tint(Color(.black))

    }
}

#Preview {
    HobTabView()
}
