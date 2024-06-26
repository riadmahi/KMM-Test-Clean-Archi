//
//  RepositoryProvider.swift
//  iosApp
//
//  Created by Riad MAHI on 10/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesRxSwift
import Combine

class RepositoryProvider {
    static let shared = RepositoryProvider()
    let hobRepository: HobRepository
    @Published public var profileUiState: ProfileUiState = ProfileUiStateLoading()
    
    private init() {
        let api = HobApi()
        self.hobRepository = HobRepository(api: api)
        
        let observable = createObservable(for: hobRepository.profileUiStateFlow)
        let _ = observable.subscribe(onNext: { [weak self] newState in
            DispatchQueue.main.async {
                self?.profileUiState = newState
            }
        }, onError: { error in
            print("Error: \(error)")
        })
    }
}
