//
//  RepositoryProvider.swift
//  iosApp
//
//  Created by Riad MAHI on 10/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesCombine
import Combine

class RepositoryProvider {
    static let shared = RepositoryProvider()
    let hobRepository: HobRepository
    private var cancellables = Set<AnyCancellable>()
    @Published public var profileUiState: ProfileUiState = ProfileUiStateLoading()

    private init() {
        let api = HobApi()
        self.hobRepository = HobRepository(api: api)
        
        let publisher = createPublisher(for: hobRepository.profileUiStateFlow)
        publisher
            .receive(on: DispatchQueue.main)
            .sink(receiveCompletion: { completion in
                switch completion {
                case .finished:
                    // Handle successful completion (optional)
                    break
                case .failure(let error):
                    // Handle error
                    print("Error received: \(error)")
                }
            }, receiveValue: { [weak self] newState in
                print(newState)
                self?.profileUiState = newState
            })
            .store(in: &cancellables)
    }
}
