import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {ThemeModule} from '../@theme/theme.module';
import {PagesRoutingModule} from './pages-routing.module';
import {DashboardModule} from './dashboard/dashboard.module';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    DashboardModule
  ],
  declarations: [
    ...PAGES_COMPONENTS
  ],
})
export class PagesModule {
}
