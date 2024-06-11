import SwiftUI
import shared

enum CurrentView:Int {
    case onboarding
    case home
}

class NavGraph : ObservableObject {
    @Published var currentView = CurrentView.onboarding
}

struct ContentView: View {

    @StateObject private var navGraph = NavGraph()
    private var repository: HobRepository
    
    init(repository: HobRepository = RepositoryProvider.shared.hobRepository) {
        self.repository = repository
    }
    
	
    var body: some View {
        Group {
            switch(navGraph.currentView) {
            case .home:
                HobTabView()
            case .onboarding:
                WelcomeScreen()
                    .environmentObject(navGraph)
            }
        }
        .task {
            do {
            let current = try await repository.checkToken()
                navGraph.currentView = current as? Bool ?? false ? .home : .onboarding
        } catch {
            // Gérer l'erreur ici
            print("Une erreur s'est produite lors de la vérification du jeton : \(error)")
        }
        }
    }
}
