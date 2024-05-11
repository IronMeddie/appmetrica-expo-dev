import ExpoModulesCore
import AppMetricaCore
import AppMetricaCrashes

public class AppMetricaModule: Module {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  public func definition() -> ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('AppMetrica')` in JavaScript.
      Name("AppMetrica")

      Function("activate") { (config: AppMetricaConfig) in
          let configuration = config.toConfig()
          let crashesConfig = config.toCrashConfig()
          AppMetrica.activate(with: configuration)
          AppMetricaCrashes.crashes().setConfiguration(crashesConfig)
      }
      Function("reportEvent") { (name: String, jsonValue: String?) in
          AppMetrica.reportEvent(name: name, parameters: jsonToDictionary(json: jsonValue ?? ""), onFailure: nil)
      }
      Function("sendEventsBuffer") { () -> Void in
          AppMetrica.sendEventsBuffer()
      }
      Function("clearAppEnvironment") { () -> Void in
          AppMetrica.clearAppEnvironment()
      }
      Function("putAppEnvironmentValue") { (key: String, value: String?) in
          AppMetrica.setAppEnvironment(value, forKey: key)
      }
      Function("getDeviceId") {
         return AppMetrica.deviceID
      }

      Function("resumeSession") { () -> Void in
          AppMetrica.resumeSession()
      }

      Function("pauseSession") { () -> Void in
          AppMetrica.pauseSession()
      }
      Function("reportAppOpen") { (link: String) in
          AppMetrica.trackOpeningURL(URL(string: link)!)
      }
      Function("reportError") { (identifier: String, message: String?) in
          let error = AppMetricaError(identifier: identifier, message: message, parameters: nil)
          AppMetricaCrashes.crashes().report(error: error)
      }
      Function("setDataSendingEnabled") { (enabled: Bool) in
          AppMetrica.setDataSendingEnabled(enabled)
      }
      Function("getLibraryVersion") {
          AppMetrica.libraryVersion
      }
      Function("getLibraryApiLevel") {
          ""
      }
      
    
    // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
    // Constants([
    //   "PI": Double.pi
    // ])

    // // Defines event names that the module can send to JavaScript.
    // Events("onChange")

    // // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    // Function("hello") {
    //   return "Hello world! 👋"
    // }

    // // Defines a JavaScript function that always returns a Promise and whose native code
    // // is by default dispatched on the different thread than the JavaScript runtime runs on.
    // AsyncFunction("setValueAsync") { (value: String) in
    //   // Send an event to JavaScript.
    //   self.sendEvent("onChange", [
    //     "value": value
    //   ])
    // }

    // // Enables the module to be used as a native view. Definition components that are accepted as part of the
    // // view definition: Prop, Events.
    // View(AppMetricaView.self) {
    //   // Defines a setter for the `name` prop.
    //   Prop("name") { (view: AppMetricaView, prop: String) in
    //     print(prop)
    //   }
    // }
  }
}

func jsonToDictionary(json: String) -> [String: Any]? {
  if let data = json.data(using: .utf8) {
    do {
      return try JSONSerialization.jsonObject(with: data, options: []) as? [String: Any]
    } catch {
      print(error.localizedDescription)
    }
  }
  return nil
}
