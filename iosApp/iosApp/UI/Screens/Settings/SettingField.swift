//
//  SettingField.swift
//  iosApp
//
//  Created by Riad MAHI on 25/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SettingField: View {
    var fieldName: String
    var field: String
    var body: some View {
            VStack {
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
                }.padding(.vertical, 2).padding(.horizontal, 16)
                Divider().padding(.horizontal, 16)
            }
        
    }
}

#Preview {
    SettingField(fieldName: "Prénom", field: "Riad")
}
