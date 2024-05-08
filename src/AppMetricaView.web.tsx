import * as React from 'react';

import { AppMetricaViewProps } from './AppMetrica.types';

export default function AppMetricaView(props: AppMetricaViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
