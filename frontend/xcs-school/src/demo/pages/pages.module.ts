import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {PagesRoutingModule} from './pages-routing.module';
import {CommonModule} from '@angular/common';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    CommonModule,
    PagesRoutingModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS
  ],
})
export class PagesModule {
}
