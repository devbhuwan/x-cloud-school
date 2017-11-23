import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {XcsCoreModule} from '../app/xcs-core.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    XcsCoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
