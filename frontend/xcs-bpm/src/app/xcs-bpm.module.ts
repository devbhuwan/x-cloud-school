import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BpmPanelComponent} from './bpm-panel/bpm-panel.component';

export const EXPORT_COMPONENTS = [BpmPanelComponent];

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [BpmPanelComponent],
  exports: EXPORT_COMPONENTS
})
export class XcsBpmModule {
}
