import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GridViewComponent} from './grid-view/grid-view.component';

export const EXPORT_COMPONENTS = [GridViewComponent];

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [GridViewComponent],
  exports: EXPORT_COMPONENTS
})
export class XcsCoreModule {
}
