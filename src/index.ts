import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to AppMetrica.web.ts
// and on native platforms to AppMetrica.ts
import AppMetricaModule from './AppMetricaModule';
import AppMetricaView from './AppMetricaView';
import { ChangeEventPayload, AppMetricaViewProps } from './AppMetrica.types';

// Get the native constant value.
export const PI = AppMetricaModule.PI;

export function hello(): string {
  return AppMetricaModule.hello();
}

export async function setValueAsync(value: string) {
  return await AppMetricaModule.setValueAsync(value);
}

const emitter = new EventEmitter(AppMetricaModule ?? NativeModulesProxy.AppMetrica);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { AppMetricaView, AppMetricaViewProps, ChangeEventPayload };
