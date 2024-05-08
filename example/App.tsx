import { StyleSheet, Text, View } from 'react-native';

import * as AppMetrica from 'expo-appmetrica';
import { AppmetricaConfig } from 'expo-appmetrica/AppMetrica.types';

export default function App() {
  const config : AppmetricaConfig = {
    apiKey: "5bc36dde-92d6-4c2d-a6c4-1ac615f4dc6a",
    withLogs: true
  }
  AppMetrica.activate(config);
  AppMetrica.reportEvent("myFirstExpoEvent", '{\'key\', \'value\'}');
  AppMetrica.sendEventsBuffer();
  return (
    <View style={styles.container}>
      <Text>{'AppMetrica expo'}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
