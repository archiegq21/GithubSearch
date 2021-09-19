//
//  SearchView.swift
//  iosApp (iOS)
//
//  Created by Archie Quinones on 9/19/21.
//

import SwiftUI

struct SearchView: View {
    
    
    var body: some View {
        VStack {
            SearchTopBar()
            ScrollView(.vertical, showsIndicators: false) {
                LazyVStack(alignment: .center) {
                    ForEach(1...100, id: \.self) { index in
                        Text("Row \(index)")
                    }
                }
            }
        }
    }
    
}


struct SearchTopBar: View {
    @State var searchText = ""
     
     var body: some View {
        VStack(alignment: .leading) {
            Text("Github Search")
            ZStack {
                Rectangle()
                    .foregroundColor(.gray)
                HStack {
                    Image(systemName: "magnifyingglass")
                    TextField("Enter Keyword", text: $searchText)
                }
                .foregroundColor(.gray)
                .padding(.leading, 10)
             }
            .frame(height: 40)
            .cornerRadius(10)
        }.padding()
     }
 }

struct SearchView_Previews: PreviewProvider {
    static var previews: some View {
        SearchView()
    }
}
