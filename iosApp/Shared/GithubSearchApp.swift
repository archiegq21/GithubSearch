import SwiftUI

@main
struct GithubSearchApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
    var body: some Scene {
        WindowGroup {
            SearchView()
        }
    }
}
