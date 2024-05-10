
import ExpoModulesCore
import AppMetricaCrashes
import AppMetricaCore

struct AppMetricaConfig: Record {
    
    @Field
    var apiKey: String = ""
    
    @Field
    var withLogs: Bool? = nil
    
    // @Field
    // var deviceType: DeviceType? = nil
    
    @Field
    var preloadInfo: PreloadInfo? = nil
    
    @Field
    var crashReporting: Bool? = nil
    
    @Field
    var probablyUnhandledCrashReporting: Bool? = nil
    
    @Field
    var ignoredCrashSignals: Array<Int>? = nil
    
    @Field
    var handleFirstActivationAsUpdate: Bool? = nil
    
    //    @Field
    //    var additionalConfig: Dictionary<String, String>? = nil
    
    @Field
    var anrMonitoring: Bool? = nil
    
    @Field
    var anrMonitoringTimeout: Int? = nil
    
    @Field
    var appBuildNumber: Int? = nil
    
    @Field
    var appEnvironmentValue: Dictionary<String, String>? = nil
    
    @Field
    var appOpenTrackingEnabled: Bool? = nil
    
    @Field
    var appVersion: String? = nil
    
    @Field
    var customHosts: Array<String>? = nil
    
    @Field
    var dataSendingEnabled: Bool? = nil
    
    @Field
    var dispatchPeriodSeconds: UInt? = nil  // Timeout for sending reports
    
    @Field
    var errorEnvironmentValue: Dictionary<String, String>? = nil
    
    @Field
    var location: LocationInfo? = nil
    
    @Field
    var locationTracking: Bool? = nil
    
    @Field
    var maxReportsCount: UInt? = nil
    
    @Field
    var maxReportsInDatabaseCount: UInt? = nil
    
    @Field
    var nativeCrashReporting: Bool? = nil
    
    @Field
    var revenueAutoTrackingEnabled: Bool? = nil
    
    @Field
    var sessionsAutoTrackingEnabled: Bool? = nil
    
    @Field
    var withSessionTimeout: UInt? = nil
    
    @Field
    var withUserProfileID: String? = nil
    
    @Field
    var applicationNotRespondingWatchdogInterval: Double? = nil
    
    @Field
    var applicationNotRespondingPingInterval: Double? = nil
    
    func toConfig() -> AppMetricaConfiguration {
        let configuration = AppMetricaConfiguration(apiKey: apiKey)
        if (withLogs != nil) {
            configuration?.areLogsEnabled = withLogs!
        }
        if (sessionsAutoTrackingEnabled != nil) {
            configuration?.sessionsAutoTracking = sessionsAutoTrackingEnabled!
        }
        if (preloadInfo != nil) {
            configuration?.preloadInfo = preloadInfo!.toPreloadInfo()
        }
        if (appOpenTrackingEnabled != nil) {
            configuration?.appOpenTrackingEnabled = appOpenTrackingEnabled!
        }
        if (appVersion != nil) {
            configuration?.appVersion = appVersion!
        }
        if (appBuildNumber != nil) {
            configuration?.appBuildNumber = String(appBuildNumber!)
        }
        if (customHosts != nil) {
            configuration?.customHosts = customHosts!
        }
        if (handleFirstActivationAsUpdate != nil) {
            configuration?.handleFirstActivationAsUpdate = handleFirstActivationAsUpdate!
        }
        if (appEnvironmentValue != nil) {
            appEnvironmentValue?.forEach({ (key: String, value: String) in
                AppMetrica.setAppEnvironment(value, forKey: key)  // todo check is it works before initializing
            })
        }
        if (appOpenTrackingEnabled != nil) {
            configuration?.appOpenTrackingEnabled = appOpenTrackingEnabled!
        }
        configuration?.appVersion = appVersion
        if (dataSendingEnabled != nil) {
            configuration?.dataSendingEnabled = dataSendingEnabled!
        }
        if (dispatchPeriodSeconds != nil) {
            configuration?.dispatchPeriod = dispatchPeriodSeconds!
        }
        if (location != nil) {
            configuration?.customLocation = location!.toLocation()
        }
        if (locationTracking != nil) {
            configuration?.locationTracking = locationTracking!
        }
        if (maxReportsCount != nil) {
            configuration?.maxReportsCount = maxReportsCount!
        }
        if (maxReportsInDatabaseCount != nil) {
            configuration?.maxReportsInDatabaseCount = maxReportsInDatabaseCount!
        }
        if (revenueAutoTrackingEnabled != nil) {
            configuration?.revenueAutoTrackingEnabled = revenueAutoTrackingEnabled!
        }
        if (sessionsAutoTrackingEnabled != nil) {
            configuration?.sessionsAutoTracking = sessionsAutoTrackingEnabled!
        }
        if (withSessionTimeout != nil) {
            configuration?.sessionTimeout = withSessionTimeout!
        }
        configuration?.userProfileID = withUserProfileID
        return configuration!
    }
    
    func toCrashConfig() -> AppMetricaCrashesConfiguration {
        let configuration = AppMetricaCrashesConfiguration()
        if let crashReporting = crashReporting {
            configuration.autoCrashTracking = crashReporting
        }
        if let probablyUnhandledCrashReporting = probablyUnhandledCrashReporting {
            configuration.probablyUnhandledCrashReporting = probablyUnhandledCrashReporting
        }
        if let ignoredCrashSignals = ignoredCrashSignals {
            configuration.ignoredCrashSignals = ignoredCrashSignals.map({ element in
                NSNumber(value: element)
            })
        }
        if let anrMonitoring = anrMonitoring {
            configuration.applicationNotRespondingDetection = anrMonitoring
        }
        if (errorEnvironmentValue != nil) {
            errorEnvironmentValue?.forEach({ (key: String, value: String) in
                AppMetricaCrashes.crashes().set(errorEnvironmentValue: value, forKey: key) // todo check
            })
        }
        
        
        //        a != nil ? a! : b
        if (applicationNotRespondingWatchdogInterval != nil) {
            configuration.applicationNotRespondingWatchdogInterval = applicationNotRespondingWatchdogInterval!  // todo anrMonitoringTimeout?
        }
        if (applicationNotRespondingPingInterval != nil) {
            configuration.applicationNotRespondingPingInterval = applicationNotRespondingPingInterval!
        }
        return configuration
    }
}
