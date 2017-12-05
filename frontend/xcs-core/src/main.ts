import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import {AppModule} from './demo/app.module';
import {environment} from './environments/environment';
import {KeycloakService} from './app/@security/keycloak/keycloak.service';

if (environment.production) {
  enableProdMode();
}

KeycloakService.init({
  url: environment.KEYCLOAK_URL,
  realm: environment.KEYCLOAK_REALM,
  clientId: environment.KEYCLOAK_CLIENTID
}).then(() => {
  const platform = platformBrowserDynamic();
  platform.bootstrapModule(AppModule);
});
