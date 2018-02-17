import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoggerService} from './logger.service';

const SERVICES = [LoggerService];

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class LoggerModule {
  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: LoggerModule,
      providers: [
        ...SERVICES,
      ],
    };
  }
}
