import { Injectable } from '@angular/core';
import {CanActivate, CanLoad, Router} from '@angular/router';
import {KeycloakService} from './keycloak.service';
import {LoggerService} from '../../@core/logger/logger.service';

@Injectable()
export class AuthGuardService implements CanActivate, CanLoad {

  constructor(public router: Router,
              private keycloakService: KeycloakService, private logger: LoggerService) {
  }

  canActivate(): boolean {
    return false;
  }

  canLoad(): boolean {
    if (KeycloakService.auth.loggedIn && KeycloakService.auth.authz.authenticated) {
      this.logger.info("user has been successfully authenticated");
      return true;
    } else {
      this.keycloakService.logout();
      return false;
    }
  }

}
