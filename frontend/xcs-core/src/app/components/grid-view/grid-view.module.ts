import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BasicGridViewComponent } from './basic-grid-view/basic-grid-view.component';
import {NotificationModule} from '../notification/notification.module';

@NgModule({
  imports: [
    CommonModule,
    NotificationModule
  ],
  declarations: [BasicGridViewComponent]
})
export class GridViewModule { }
