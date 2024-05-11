package io.appmetrica.analytics.expo

import android.content.Context
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.StartupParamsCallback
import io.appmetrica.analytics.expo.models.AdRevenue
import io.appmetrica.analytics.expo.models.AppMetricaConfig
import io.appmetrica.analytics.expo.models.EcommerceEvent
import io.appmetrica.analytics.expo.models.Revenue
import io.appmetrica.analytics.expo.models.StartupParams

class AppMetricaModule : Module() {

    var context : Context? = null

    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    override fun definition() = ModuleDefinition {
        context = appContext.reactContext
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('AppMetrica')` in JavaScript.
        Name("AppMetrica")
        Function("activate") { config: AppMetricaConfig ->
            val context = context?.applicationContext
            AppMetrica.activate(context ?: throw CantGetContext(), config.toConfig())
            val activity = appContext.currentActivity
            if (config.appOpenTrackingEnabled != false && activity != null) {
                AppMetrica.enableActivityAutoTracking(activity.application)
            }
        }

        Function("reportEvent") { name: String, params: String? ->
            AppMetrica.reportEvent(name, params)
        }

        Function("sendEventsBuffer") {
            AppMetrica.sendEventsBuffer()
        }

        Function("clearAppEnvironment") {
            AppMetrica.clearAppEnvironment()
        }

        Function("putAppEnvironmentValue") { key: String, value: String? ->
            AppMetrica.putAppEnvironmentValue(key, value)
        }

        Function("getDeviceId") { key: String, value: String? ->
            AppMetrica.getDeviceId(
                context?.applicationContext ?: throw CantGetContext()
            )
        }

        Function("resumeSession") {
            AppMetrica.resumeSession(appContext.currentActivity)
        }

        Function("getLibraryApiLevel") {
            AppMetrica.getLibraryApiLevel()
        }

        Function("pauseSession") {
            AppMetrica.pauseSession(appContext.currentActivity)
        }

        Function("reportAppOpen") { link: String ->
            AppMetrica.reportAppOpen(link)
        }

        Function("reportError") { identifier: String, message: String? ->
            AppMetrica.reportError(identifier, message)
        }

        Function("setDataSendingEnabled") { enabled: Boolean ->
            AppMetrica.setDataSendingEnabled(enabled)
        }

        Function("getLibraryVersion") {
            AppMetrica.getLibraryVersion()
        }

        Function("getUuid") {
            if (context != null) {
                AppMetrica.getUuid(context!!)
            }
        }

        Function("reportAdRevenue") { adRevenue: AdRevenue ->
            AppMetrica.reportAdRevenue(adRevenue.toAdRevenue())
        }

        Function("reportAdRevenue") { revenue: Revenue ->
            AppMetrica.reportRevenue(revenue.toRevenue())
        }

        Function("putErrorEnvironmentValue") { key: String, value: String? ->
            AppMetrica.putErrorEnvironmentValue(key, value)
        }

        AsyncFunction("requestStartupParams") { keys: List<String> ->
            if (context != null) {
                AppMetrica.requestStartupParams(context!!, object : // todo refactor
                    StartupParamsCallback {
                    override fun onReceive(result: StartupParamsCallback.Result?) {
                        sendEvent("startupParamsOnReceive", mapOf(
                            StartupParams.APPMETRICA_DEVICE_ID_HASH.name to result?.deviceIdHash,
                            StartupParams.APPMETRICA_DEVICE_ID.name to result?.deviceId,
                            StartupParams.APPMETRICA_UUID.name to result?.uuid
                        ))
                    }

                    override fun onRequestError(
                        reason: StartupParamsCallback.Reason,
                        result: StartupParamsCallback.Result?
                    ) {
                        sendEvent("startupParamsOnError", mapOf(
                            "reason" to reason.value,
                            "result" to result?.parameters
                        ))
                    }
                }, keys)
            }
        }
        Events("startupParamsOnReceive", "startupParamsOnError")

        Function("reportECommerce") { event: EcommerceEvent ->
//   todo   AppMetrica.reportECommerce()
        }
        // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
//    Constants(
//      "PI" to Math.PI
//    )

        // Defines event names that the module can send to JavaScript.
//    Events("onChange")

        // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
//    Function("hello") {
//      "Hello world! 👋"
//    }

        // Defines a JavaScript function that always returns a Promise and whose native code
        // is by default dispatched on the different thread than the JavaScript runtime runs on.
//    AsyncFunction("setValueAsync") { value: String ->
//      // Send an event to JavaScript.
//      sendEvent("onChange", mapOf(
//        "value" to value
//      ))
//    }

//    // Enables the module to be used as a native view. Definition components that are accepted as part of
//    // the view definition: Prop, Events.
//    View(AppMetricaView::class) {
//      // Defines a setter for the `name` prop.
//      Prop("name") { view: AppMetricaView, prop: String ->
//        println(prop)
//      }
//    }
    }
}


