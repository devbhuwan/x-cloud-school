import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {PagesRoutingModule} from './pages-routing.module';
import {CommonModule} from '@angular/common';
import {ThemeModule} from 'xcs-core';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    ThemeModule,
    PagesRoutingModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS
  ],
})
export class PagesModule {
}
