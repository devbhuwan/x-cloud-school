import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SchoolPagesRoutingModule} from './school-pages-routing.module';
import {SchoolDashboardComponent} from './school-dashboard/school-dashboard.component';

const COMPONENTS = [
  SchoolDashboardComponent
];

@NgModule({
  imports: [
    CommonModule,
    SchoolPagesRoutingModule
  ],
  declarations: [...COMPONENTS],
  exports: [...COMPONENTS]
})
export class SchoolPagesModule {
  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: SchoolPagesModule,
      providers: [],
    };
  }
}
