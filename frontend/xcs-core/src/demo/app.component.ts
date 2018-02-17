import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'xcs-app',
  template: `
    <router-outlet></router-outlet>`
})
export class AppComponent {

  constructor(private http: HttpClient) {

  }

  retrieveData() {
    console.log('Hello');
    this.http.get('/hello').subscribe(res => {
      console.log(JSON.stringify(res));
    });
  }
}
