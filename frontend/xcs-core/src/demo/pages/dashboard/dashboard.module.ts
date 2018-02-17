import {NgModule} from '@angular/core';

import {ThemeModule} from '../../../app';
import {DashboardComponent} from './dashboard.component';
import {StatusCardComponent} from '../status-card/status-card.component';


@NgModule({
  imports: [
    ThemeModule,
  ],
  declarations: [
    DashboardComponent,
    StatusCardComponent
  ],
  providers: []
})
export class DashboardModule {
}
