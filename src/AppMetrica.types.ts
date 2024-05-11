export type ChangeEventPayload = {
  value: string;
};

export type AppMetricaViewProps = {
  name: string;
};

export type AppmetricaConfig = {
  apiKey: string;
  withLogs?: boolean;
  deviceType?: DeviceType; // android only
  preloadInfo?: PreloadInfo;
  crashReporting?: boolean;
  probablyUnhandledCrashReporting?: boolean; // ios only
  ignoredCrashSignals?: Array<number>; // ios only
  handleFirstActivationAsUpdat?: boolean;
  additionalConfig?: Map<string,string>; // android only
  anrMonitoring?: boolean;
  anrMonitoringTimeout?: number;
  appBuildNumber?: number;
  appEnvironmentValue?: Map<string,string>;
  appOpenTrackingEnabled?: boolean;
  appVersion?: string;
  customHosts?: Array<string>;
  dataSendingEnabled?: boolean;
  dispatchPeriodSeconds?: number;
  errorEnvironmentValue?: Map<string,string>;
  location?: LocationInfo;
  locationTracking?: boolean;
  maxReportsCount?: number;
  maxReportsInDatabaseCount?: number;
  nativeCrashReporting?: boolean;
  revenueAutoTrackingEnabled?: boolean;
  withSessionTimeout?: number;
  sessionsAutoTrackingEnabled?: boolean;
  withUserProfileID?: string;
  applicationNotRespondingWatchdogInterval?: number; // ios only
  applicationNotRespondingPingInterval?: number // ios only
};

export type LocationInfo = {
  latitude: number;
  longitude: number;
  altitude?: number;
  accuracy?: number;
  verticalAccuracy?: number; 
  course?: number;
  speed?: number;
  timestamp?: number;
};

export type DeviceType = 'car' | 'tv' | 'phone' | 'tablet';

export type PreloadInfo = {
  trackingID: string;
  additionalParams?: Map<string,string>;
};

export type AdType = "native" | "banner" | "mrec" | "interstitial" | "rewarded" | "other";

export type StartupParams = "appmetrica_device_id_hash" | "appmetrica_uuid" | "appmetrica_device_id"

export type AdRevenue = {
  price: number;
  currency: string;
  payload?: Map<string, string>;
  adType?: AdType;
  adNetwork?: string;
  adPlacementID?: string;
  adPlacementName?: string;
  adUnitID?: string;
  adUnitName?: string;
  precision: string;
}

export type Revenue = {
  price: number;
  currency: string;
  payload?: string;
  productID?: string;
  quantity?: number;
  receiptData?: string;
  signature: string;
}
