import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {SecuredHttpInterceptor} from './keycloak/http-interceptor';
import {AuthGuardService} from './keycloak/auth-guard.service';
import {KeycloakService} from './keycloak/keycloak.service';


function xcsSecurityProviders() {
  return [
    KeycloakService,
    AuthGuardService,
    xcsSecurityHttpInterceptor()
  ];
}

function xcsSecurityHttpInterceptor() {
  return {
    provide: HTTP_INTERCEPTORS,
    useFactory: (keycloakService: KeycloakService) => {
      return new SecuredHttpInterceptor(keycloakService);
    },
    deps: [KeycloakService],
    multi: true
  };
}

@NgModule({
  imports: [
    CommonModule,
  ],
  exports: [],
  declarations: [],
  providers: [
    ...xcsSecurityProviders()
  ]
})
export class SecurityModule {

  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: SecurityModule,
      providers: [],
    };
  }
}
