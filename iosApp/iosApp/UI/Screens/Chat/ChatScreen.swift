//
//  ChatScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ChatScreen: View {
    var body: some View {
        VStack {
            ScrollView {
                ChatHeader()
                ChatContent()
            }
        }
    }
}

struct ChatHeader: View {
    var body: some View {
        HStack {
            Text("Chat")
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

struct ChatContent: View {
    var body: some View {
        VStack {
           ChatCard(photoUrl: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
                    name: "Marina", lastMessage: "Eh carrément trop cool!")
            ChatCard(photoUrl: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
                     name: "Marina", lastMessage: "Eh carrément trop cool!")
            ChatCard(photoUrl: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
                     name: "Marina", lastMessage: "Eh carrément trop cool!")
            ChatCard(photoUrl: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
                     name: "Marina", lastMessage: "Eh carrément trop cool!")
            ChatCard(photoUrl: "https://images.unsplash.com/photo-1717278920189-f69e4697dcc1?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
                     name: "Marina", lastMessage: "Eh carrément trop cool!")
        }
    }
}


#Preview {
    ChatScreen()
}
