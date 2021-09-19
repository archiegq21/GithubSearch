import UIKit
import common

class AppDelegate: NSObject, UIApplicationDelegate {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        
        KoinKt.doInitKoin(platformModule: IosModuleKt.iosModule())
        
        return true
    }
}
