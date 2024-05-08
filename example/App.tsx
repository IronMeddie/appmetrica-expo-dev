import { StyleSheet, Text, View } from 'react-native';

import * as AppMetrica from 'expo-appmetrica';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>{AppMetrica.hello()}</Text>
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
