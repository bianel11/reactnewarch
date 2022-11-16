import React, {useState} from 'react';
import {SafeAreaView, StatusBar, Text, Button} from 'react-native';
import Calculator from 'calculator/src/index';

const App = () => {
  const [currentResult, setResult] = useState(0);
  return (
    <SafeAreaView>
      <StatusBar barStyle={'dark-content'} />
      <Text style={{marginLeft: 20, marginTop: 20}}>
        3+7={currentResult ?? '??'}
      </Text>
      <Button
        title="Compute"
        onPress={async () => {
          const result = await Calculator.add(currentResult, 7);
          setResult(result);
        }}
      />
    </SafeAreaView>
  );
};
export default App;
