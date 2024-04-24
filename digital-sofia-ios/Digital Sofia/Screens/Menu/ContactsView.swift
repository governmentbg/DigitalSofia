//
//  ContactsView.swift
//  Digital Sofia
//
//  Created by Teodora Georgieva on 2.08.23.
//

import SwiftUI

struct ContactsView: View {
    @EnvironmentObject var networkMonitor: NetworkMonitor
    @EnvironmentObject var appState: AppState
    
    var body: some View {
        VStack(spacing: 0) {
            CustomNavigationBar()
            
            Rectangle()
                .fill(DSColors.Text.placeholder.opacity(0.1))
                .frame(height: 1)
                .edgesIgnoringSafeArea(.horizontal)
            
            DSWebView(type: .contacts)
                .environmentObject(appState)
                .environmentObject(networkMonitor)
        }
        .log(view: self)
        .lockScreen()
        .loginNotification()
        .environmentObject(appState)
        .environmentObject(networkMonitor)
        .backgroundAndNavigation()
    }
}

struct ContactsView_Previews: PreviewProvider {
    static var previews: some View {
        ContactsView()
    }
}
