import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BpmPanelComponent} from './bpm-panel/bpm-panel.component';

import {XcsCoreModule} from '@xcs/xcs-core';

export const EXPORT_COMPONENTS = [BpmPanelComponent];

@NgModule({
  imports: [
    CommonModule,
    XcsCoreModule
  ],
  declarations: [BpmPanelComponent],
  exports: EXPORT_COMPONENTS
})
export class XcsBpmModule {
}
