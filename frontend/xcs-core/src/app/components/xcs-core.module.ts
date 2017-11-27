import {NgModule} from '@angular/core';
import {ThemeModule} from '../@theme/theme.module';
import {GridViewModule} from './grid-view/grid-view.module';

@NgModule({
  imports: [
    ThemeModule,
    GridViewModule
  ],
  exports: []
})
export class XcsCoreModule {
}
