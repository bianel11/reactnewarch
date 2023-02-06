import React, { useState } from 'react';
import { SafeAreaView, StatusBar, Text, Button, Alert } from 'react-native';
import Calculator from 'calculator/src/index';

function App() {
  const [currentResult, setResult] = useState(0);

  return (
    <SafeAreaView style={{ backgroundColor: 'white' }}>
      <StatusBar barStyle={'dark-content'} />
      <Text
        style={{
          marginLeft: 20,
          marginTop: 20,
          color: 'black',
          fontWeight: 'bold',
        }}>
        3+7={currentResult ?? '??'}
      </Text>
      <Button
        title="Compute"
        onPress={async () => {
          const result = await Calculator.add(currentResult, 7);
          const { brand, version, model } = await Calculator.returnPhoneInfo();
          console.log('Phone Info', { brand, version, model });
          Alert.alert('Result', `${brand} ${version} ${model}`);
          setResult(result);
        }}
      />
    </SafeAreaView>
  );
}

export default App;
