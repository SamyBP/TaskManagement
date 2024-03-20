import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AuthModule} from "./auth/auth.module";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {JwtModule} from "@auth0/angular-jwt";
import {HttpClientModule} from "@angular/common/http";
import {HomeModule} from "./home/home.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    JwtModule.forRoot({
      config: {
        tokenGetter: () => localStorage.getItem('token'),
        allowedDomains: ['localhost:8080']
      }
    }),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AuthModule,
    HomeModule
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
