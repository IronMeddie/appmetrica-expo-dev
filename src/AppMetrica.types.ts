export type ChangeEventPayload = {
  value: string;
};

export type AppMetricaViewProps = {
  name: string;
};

export type AppmetricaConfig = {
  apiKey: string;
  withLogs?: boolean;
  deviceType?: DeviceType;
  preloadInfo?: PreloadInfo;
  crashReporting?: boolean;
  handleFirstActivationAsUpdat?: boolean;
  additionalConfig?: Map<string,string>;
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
  withUserProfileID?: string;
};

export type LocationInfo = {
  latitude: number;
  longitude: number;
  altitude?: number;
  accuracy?: number;
  course?: number;
  speed?: number;
  timestamp?: number;
};

export type DeviceTypeTest = 'CAR' | 'TV' | 'PHONE' | 'TABLET';
export type DeviceType = 'car' | 'tv' | 'phone' | 'tablet';

export type PreloadInfo = {
  trackingID: string;
  additionalParams?: Map<string,string>;
};
