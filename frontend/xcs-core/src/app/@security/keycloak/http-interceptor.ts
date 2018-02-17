import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/observable/fromPromise';
import 'rxjs/add/observable/interval';
import {KeycloakService} from './keycloak.service';
import {fromPromise} from 'rxjs/observable/fromPromise';

@Injectable()
export class SecuredHttpInterceptor implements HttpInterceptor {

  public constructor(private _keycloakService: KeycloakService) {
  }

  intercept(request: HttpRequest<any>,
            next: HttpHandler): Observable<HttpEvent<any>> {
    return fromPromise(this._keycloakService.getToken())
      .switchMap(token => {
        const headers = request.headers
          .set('Authorization', 'Bearer ' + token)
          .append('Content-Type', 'application/json');
        const reqClone = request.clone({
          headers
        });
        return next.handle(reqClone);
      });
  }
}
