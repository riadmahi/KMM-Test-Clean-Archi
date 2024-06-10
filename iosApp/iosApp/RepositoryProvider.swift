//
//  RepositoryProvider.swift
//  iosApp
//
//  Created by Riad MAHI on 10/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class RepositoryProvider {
    static let shared = RepositoryProvider()
    
    let hobRepository: HobRepository

    private init() {
        let api = HobApi()
        self.hobRepository = HobRepository(api: api)
    }
}
