
// struct FileReadOptions: Record {
//   @Field
//   var encoding: String = "utf8"

//   @Field
//   var position: Int = 0

//   @Field
//   var length: Int
// }
import ExpoModulesCore

struct AppMetricaConfig: Record {

    @Field
    var apiKey: String = ""

    @Field
    var withLogs: Bool? = nil

    @Field
    var deviceType: DeviceType? = nil

    // @Field
    // var preloadInfo: PreloadInfo? = nil

    @Field
    var crashReporting: Bool? = nil

    @Field
    var handleFirstActivationAsUpdate: Bool? = nil

    // @Field
    // var additionalConfig: NSDictionary? = nil

    @Field
    var anrMonitoring: Bool? = nil

    @Field
    var anrMonitoringTimeout: Int? = nil

    @Field
    var appBuildNumber: Int? = nil

    // @Field
    // var appEnvironmentvarue: NSDictionary? = nil

    @Field
    var appOpenTrackingEnabled: Bool? = nil

    @Field
    var appVersion: String? = nil

    // @Field
    // var customHosts: NSArray? = nil

    @Field
    var dataSendingEnabled: Bool? = nil

    @Field
    var dispatchPeriodSeconds: Int? = nil

    // @Field
    // var errorEnvironmentvarue: NSDictionary? = nil

    // @Field
    // var location: LocationInfo? = nil

    @Field
    var locationTracking: Bool? = nil

    @Field
    var maxReportsCount: Int? = nil

    @Field
    var maxReportsInDatabaseCount: Int? = nil

    @Field
    var nativeCrashReporting: Bool? = nil

    @Field
    var revenueAutoTrackingEnabled: Bool? = nil

    @Field
    var withSessionTimeout: Int? = nil

    @Field
    var withUserProfileID: String? = nil
}