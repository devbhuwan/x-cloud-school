import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SchoolDashboardComponent} from './school-dashboard/school-dashboard.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: SchoolDashboardComponent
  },
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SchoolPagesRoutingModule {
}
