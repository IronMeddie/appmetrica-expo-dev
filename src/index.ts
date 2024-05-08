import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to AppMetrica.web.ts
// and on native platforms to AppMetrica.ts
import AppMetricaModule from './AppMetricaModule';
import { AppmetricaConfig } from './AppMetrica.types';


export function activate(config: AppmetricaConfig) {
  AppMetricaModule.activate(config);
};

export function reportEvent(name: string, jsonValue?: string) {
  AppMetricaModule.reportEvent(name, jsonValue);
};

export function sendEventsBuffer() {
  AppMetricaModule.sendEventsBuffer();
};

// export async function setValueAsync(value: string) {
//   return await AppMetricaModule.setValueAsync(value);
// }

// const emitter = new EventEmitter(AppMetricaModule ?? NativeModulesProxy.AppMetrica);

// export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
//   return emitter.addListener<ChangeEventPayload>('onChange', listener);
// }

// export { AppMetricaView, AppMetricaViewProps, ChangeEventPayload };
