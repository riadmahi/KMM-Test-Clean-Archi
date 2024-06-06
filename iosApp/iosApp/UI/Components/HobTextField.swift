//
//  HobTextField.swift
//  iosApp
//
//  Created by Riad MAHI on 06/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HobTextField: View {
    var hint: String
    @Binding var text: String
    
    var body: some View {
        TextField(
            hint,
            text: $text
        )
        .padding(.vertical, 18)
        .padding(.horizontal, 16)
        .background(Color("SecondBgColor"))
        .textInputAutocapitalization(.never)
        .clipShape(RoundedRectangle(cornerRadius: 8))
        .font(Font.custom("BRSonoma-Regular", size: 16))
        .accentColor(Color("AccentColor"))
    }
}

#Preview {
    HobTextFieldPreview()
}

struct HobTextFieldPreview: View {
    @State var text = ""
    
    var body: some View {
        HobTextField(hint: "Email", text: $text)
            .padding()
            .previewLayout(.sizeThatFits)
    }
}
