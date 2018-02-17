import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SchoolPagesRoutingModule} from './school-pages-routing.module';
import {SchoolDashboardComponent} from './school-dashboard/school-dashboard.component';
import { ThemeModule } from 'xcs-core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormioModule } from 'angular-formio';

const COMPONENTS = [
  SchoolDashboardComponent
];

@NgModule({
  imports: [
    ThemeModule,
    ReactiveFormsModule,
    FormioModule,
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
