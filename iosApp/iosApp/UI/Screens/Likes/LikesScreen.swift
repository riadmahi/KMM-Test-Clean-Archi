//
//  LikesScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LikesScreen: View {
    var body: some View {
        VStack {
            LikesHeader()
            LikesContent()
        }
    }
}

struct LikesHeader: View {
    var body: some View {
        HStack {
            Text("Likes")
                .font(Font.custom("BRSonoma-SemiBold", size: 18))
            
            ZStack {
                Circle()
                    .frame(width: 18)
                    .foregroundColor(Color("AccentColor"))
                Text("6")
                    .foregroundColor(.white)
                    .font(Font.custom("BRSonoma-Bold", size: 12))
            }
        }.padding(.vertical, 12)

    }
}

struct LikesContent: View {
    var body: some View {
        ScrollView {
            Grid {
                GridRow {
                    LikesCard(url: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D")
                    LikesCard(
                        url:"https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D")
                }
                GridRow {
                    LikesCard(url: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D")
                    LikesCard(
                        url:"https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D")
                }
            }
        }

    }
}

struct LikesCard: View {
    var url: String
    var body: some View {
        AsyncImage(url: URL(string: url)){ result in
            result.image?
                .resizable()
                .scaledToFill()
                .blur(radius: 20)
        }.frame(width: 180, height: 260).clipShape(RoundedRectangle(cornerSize: CGSize(width: 20, height: 10)))
    }
}

#Preview {
    LikesScreen()
}
