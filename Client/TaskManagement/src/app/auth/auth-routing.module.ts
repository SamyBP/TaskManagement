import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./sign-in/sign-in.component";
import {SignUpComponent} from "./sign-up/sign-up.component";

const routes: Routes = [
  {path : 'app/auth/sign-in', component : SignInComponent},
  {path : 'app/auth/sign-up', component :SignUpComponent},
  {path : '', redirectTo : '/app/auth/sign-in', pathMatch : "full"}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
