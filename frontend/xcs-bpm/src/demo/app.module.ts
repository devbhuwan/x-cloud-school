import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {XcsBpmModule} from '../app/xcs-bpm.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    XcsBpmModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
