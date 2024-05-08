import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { AppMetricaViewProps } from './AppMetrica.types';

const NativeView: React.ComponentType<AppMetricaViewProps> =
  requireNativeViewManager('AppMetrica');

export default function AppMetricaView(props: AppMetricaViewProps) {
  return <NativeView {...props} />;
}
