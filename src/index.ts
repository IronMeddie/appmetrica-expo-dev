import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to AppMetrica.web.ts
// and on native platforms to AppMetrica.ts
import AppMetricaModule from './AppMetricaModule';
import { AppmetricaConfig, AdRevenue, StartupParams } from './AppMetrica.types';


export function activate(config: AppmetricaConfig) {
  AppMetricaModule.activate(config);
};

export function reportEvent(name: string, jsonValue?: string) {
  AppMetricaModule.reportEvent(name, jsonValue);
};

export function sendEventsBuffer() {
  AppMetricaModule.sendEventsBuffer();
};

export function clearAppEnvironment() {
  AppMetricaModule.clearAppEnvironment();
};

export function putAppEnvironmentValue(key: string, value?: string) {
  AppMetricaModule.putAppEnvironmentValue(key, value);
}

export function getDeviceId(): string {
  return AppMetricaModule.getDeviceId();
}

export function resumeSession() {
  AppMetricaModule.resumeSession();
}

export function pauseSession() {
  AppMetricaModule.pauseSession();
}

export function getLibraryApiLevel(): number {  // android only
  return AppMetricaModule.getLibraryApiLevel();
}

export function getLibraryVersion(): string {
  return AppMetricaModule.getLibraryVersion()
}

export function reportAppOpen(link: string) {
  AppMetricaModule.reportAppOpen(link);
}

export function reportError(identifier: string, message?: string) {
  AppMetricaModule.reportError(identifier, message);
}

export function setDataSendingEnabled(enabled: boolean) {
  AppMetricaModule.setDataSendingEnabled(enabled);
}

export function reportAdRevenue(adRevenue: AdRevenue) {
  AppMetricaModule.reportAdRevenue(adRevenue);
}

export function putErrorEnvironmentValue(key: string, value?: string) {
  AppMetricaModule.putErrorEnvironmentValue(key, value);
}

export async function requestStartupParams(keys: Array<StartupParams>) {
  return await AppMetricaModule.requestStartupParams(keys);
}

// const emitter = new EventEmitter(AppMetricaModule ?? NativeModulesProxy.AppMetrica);

// export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
//   return emitter.addListener<ChangeEventPayload>('onChange', listener);
// }

// export { AppMetricaView, AppMetricaViewProps, ChangeEventPayload };
