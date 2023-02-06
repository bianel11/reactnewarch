import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {TurboModuleRegistry} from 'react-native';

type PhoneInfo = {
  brand: string;
  version: string;
  model: string;
};

export interface Spec extends TurboModule {
  add(a: number, b: number): Promise<number>;
  returnPhoneInfo(): Promise<PhoneInfo>;
}

export default TurboModuleRegistry.get<Spec>(
  'Calculator',
) as Spec;