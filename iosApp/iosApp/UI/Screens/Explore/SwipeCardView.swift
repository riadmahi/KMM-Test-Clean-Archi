//
//  SwipeCardView.swift
//  iosApp
//
//  Created by Riad MAHI on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shuffle

struct SwipeCardView: UIViewRepresentable {
    func makeUIView(context: Context) -> SwipeCard {
        return SwipeCard()
    }

    func updateUIView(_ uiView: SwipeCard, context: Context) {
        // Mettre à jour l'état de la vue ici si nécessaire
    }
}
