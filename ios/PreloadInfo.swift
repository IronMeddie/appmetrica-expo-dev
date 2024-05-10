
import ExpoModulesCore
import AppMetricaCore

struct PreloadInfo: Record {
    @Field
    var trackingID: String = ""

    @Field
    var additionalParams: Dictionary<String, String>? = nil

    func toPreloadInfo() -> AppMetricaPreloadInfo {
        let preloadInfo = AppMetricaPreloadInfo(trackingIdentifier: trackingID)
        additionalParams?.forEach({ (key: String, value: String) in
            preloadInfo?.setAdditionalInfo(info: key, for: value)
        })
        return preloadInfo!
    }
}