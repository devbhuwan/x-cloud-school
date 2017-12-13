import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import { PagesComponent } from './pages.component';


const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [{
    path: 'school', loadChildren: '../../app/pages/school-pages.module#SchoolPagesModule'
  }, {
    path: '',
    redirectTo: 'school',
    pathMatch: 'full',
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {

}
