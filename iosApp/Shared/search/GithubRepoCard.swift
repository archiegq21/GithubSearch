import SwiftUI

struct GithubRepoCard: View {
    var body: some View {
        VStack {
            HStack {
                VStack {
                    Text("Square/Retrofit")
                    Text("A type safe http client for android and jvm")
                }
            }
        }
    }
}

struct GithubRepoCard_Previews: PreviewProvider {
    static var previews: some View {
        GithubRepoCard()
    }
}
