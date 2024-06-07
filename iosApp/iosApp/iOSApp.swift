import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

   @UIApplicationDelegateAdaptor(AppDelegate.self)
   var appDelegate: AppDelegate

    var body: some Scene {
       WindowGroup {
          ContentView()
       }
    }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    private var _koin: Koin_coreKoin? = nil
    var koin: Koin_coreKoin {
        return _koin!
    }

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        startKoin()
        return true
    }

    func startKoin() {
        let koinApplication = DependencyInjectionKt.doInitKoinIOS()
        _koin = koinApplication.koin
    }
}