import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'xcs-pages',
  template: `
    <xcs-sample-layout>
      <nb-menu [items]="menu"></nb-menu>
      <router-outlet></router-outlet>
    </xcs-sample-layout>
  `
})
export class PagesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
