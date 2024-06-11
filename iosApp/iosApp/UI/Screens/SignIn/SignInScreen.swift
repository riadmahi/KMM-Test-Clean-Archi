//
//  SignInScreen.swift
//  iosApp
//
//  Created by Riad MAHI on 03/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import SwiftUI

struct SignInScreen: View {
    @State private var email: String = ""
    @State private var password: String = ""
    @State var isPasswordVisible: Bool = false
    @StateObject private var viewModel = ViewModel()
    @State private var navigateToHobTabView: Bool = false
    @EnvironmentObject var navGraph: NavGraph

    var body: some View {
        VStack(spacing: 42) {
            Text("Heureux de vous revoir! 👋")
                .font(Font.custom("BRSonoma-SemiBold", size: 24))
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 24) {
                HobTextField(hint: "Email", text: $email)
                SecureHobTextField(
                    hint: "Password",
                    password: $password,
                    isPasswordVisible: $isPasswordVisible
                )
                
                Text("Forgot your password?")
                    .frame(maxWidth: .infinity, alignment: .trailing)
                    .font(Font.custom("BRSonoma-Regular", size: 14))
                    .foregroundColor(Color("PlaceholderColor"))
            }
            
            if viewModel.uistate is SignInUiStateLoading {
                ProgressView()
            } else {
                HobButton(text: "Sign in", width: UIScreen.main.bounds.width - 32) {
                    viewModel.signIn(email: email, password: password)
                }
            }
            if let errorState = viewModel.uistate as? SignInUiStateError {
                ErrorCard(error: errorState.cause)
            }
            Spacer()
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(.horizontal, 24)
        .padding(.vertical, 32)
        .onReceive(viewModel.$uistate) { state in
            if state is SignInUiStateSuccess {
                navGraph.currentView =  .home
            }
        }
    }
}

extension SignInScreen {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var uistate: SignInUiState = SignInUiStateNone()
        private var repository: HobRepository
        
        init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
            self.repository = repository
        }
        
        func signIn(email: String, password: String) {
            self.uistate = SignInUiStateLoading()
            Task {
                do {
                    let result = try await repository.signIn(email: email, password: password)
                    DispatchQueue.main.async {
                        self.uistate = result
                    }
                } catch {
                    DispatchQueue.main.async {
                        self.uistate = SignInUiStateError(cause: error.localizedDescription)
                    }
                }
            }
        }
    }
}
