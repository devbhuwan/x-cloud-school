import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {ThemeModule} from '../../app/@theme/theme.module';
import {PagesRoutingModule} from './pages-routing.module';
import {DashboardModule} from '../../app/pages/dashboard/dashboard.module';

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
