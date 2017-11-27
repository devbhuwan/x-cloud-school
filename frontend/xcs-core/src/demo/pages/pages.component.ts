import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'xcs-pages',
  template: `
    <xcs-two-column>
      <router-outlet></router-outlet>
    </xcs-two-column>
  `
})
export class PagesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
