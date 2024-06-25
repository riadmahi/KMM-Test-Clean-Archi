//
//  SettingField.swift
//  iosApp
//
//  Created by Riad MAHI on 25/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SettingField: View {
    let fieldName: String
    let field: String
    var body: some View {
        HStack {
            VStack {
                Text(fieldName)
                    .padding(.horizontal, 6)
                    .padding(.vertical, 2)
                    .font(Font.custom("BRSonoma-Medium", size: 13))
                    .foregroundColor(Color("PlaceholderColor"))
                    .frame(maxWidth: .infinity, alignment: .leading)
                Text(field)
                    .padding(.horizontal, 6)
                    .font(Font.custom("BRSonoma-Medium", size: 15))
                    .frame(maxWidth: .infinity, alignment: .leading)
            }
            
            Image("ic_arrow_right")
        }.padding(.vertical, 2).padding(.horizontal, 32)
        Divider().padding(.horizontal, 32)
    }
}

#Preview {
    SettingField(fieldName: "Prénom", field: "Riad")
}
