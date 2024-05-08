package io.appmetrica.analytics.expo

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.AppMetricaConfig

class AppMetricaConfig: Record {
    @Field
    val apiKey: String = ""

    @Field
    val withLogs: Boolean? = null

    @Field
    val deviceType: DeviceType? = null

    @Field
    val preloadInfo: PreloadInfo? = null

    @Field
    val crashReporting: Boolean? = null

    @Field
    val handleFirstActivationAsUpdate: Boolean? = null

    @Field
    val additionalConfig: Map<String,String>? = null

    @Field
    val anrMonitoring: Boolean? = null

    @Field
    val anrMonitoringTimeout: Int? = null

    @Field
    val appBuildNumber: Int? = null

    @Field
    val appEnvironmentValue: Map<String,String>? = null

    @Field
    val appOpenTrackingEnabled: Boolean? = null

    @Field
    val appVersion: String? = null

    @Field
    val customHosts: List<String>? = null

    @Field
    val dataSendingEnabled: Boolean? = null

    @Field
    val dispatchPeriodSeconds: Int? = null

    @Field
    val errorEnvironmentValue: Map<String,String>? = null

    @Field
    val location: LocationInfo? = null

    @Field
    val locationTracking: Boolean? = null

    @Field
    val maxReportsCount: Int? = null

    @Field
    val maxReportsInDatabaseCount: Int? = null

    @Field
    val nativeCrashReporting: Boolean? = null

    @Field
    val revenueAutoTrackingEnabled: Boolean? = null

    @Field
    val withSessionTimeout: Int? = null

    @Field
    val withUserProfileID: String? = null
    
    fun toConfig() : AppMetricaConfig {
        return AppMetricaConfig.newConfigBuilder(apiKey)
            .apply {
                anrMonitoringTimeout?.let { withAnrMonitoringTimeout(it) }
                appBuildNumber?.let { withAppBuildNumber(it) }
                crashReporting?.let { withCrashReporting(it) }
                handleFirstActivationAsUpdate?.let { handleFirstActivationAsUpdate(it) }
                anrMonitoring?.let { withAnrMonitoring(it) }
                appOpenTrackingEnabled?.let { withAppOpenTrackingEnabled(it) }
                appVersion?.let { withAppVersion(it) }
                customHosts?.let { withCustomHosts(it) }
                dataSendingEnabled?.let { withDataSendingEnabled(it) }
                deviceType?.let { withDeviceType(it.value) }
                dispatchPeriodSeconds?.let { withDispatchPeriodSeconds(it) }
                locationTracking?.let { withLocationTracking(it) }
                maxReportsCount?.let { withMaxReportsCount(it) }
                maxReportsInDatabaseCount?.let { withMaxReportsInDatabaseCount(it) }
                nativeCrashReporting?.let { withNativeCrashReporting(it) }
                preloadInfo?.let { withPreloadInfo(it.toPreloadInfo()) }
                revenueAutoTrackingEnabled?.let { withRevenueAutoTrackingEnabled(it) }
                withSessionTimeout?.let { withSessionTimeout(it) }
                errorEnvironmentValue?.forEach {
                    withErrorEnvironmentValue(it.key,it.value)
                }
                if (withLogs != null && withLogs != false) {
                    withLogs()
                }
                additionalConfig?.forEach {
                    withAdditionalConfig(it.key, it.value)
                }
                appEnvironmentValue?.forEach {
                    withAppEnvironmentValue(it.key,it.value)
                }
                withLocation(location?.toLocation())
                withUserProfileID(withUserProfileID)
            }.build()
    }
}





