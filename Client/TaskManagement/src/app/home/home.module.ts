import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { TasksComponent } from './tasks/tasks.component';
import { CardComponent } from './card/card.component';
import {MatCardModule} from "@angular/material/card";
import { UserProfileFormComponent } from './user-profile-form/user-profile-form.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import { HeaderComponent } from './header/header.component';
import {MatIconModule} from "@angular/material/icon";
import {MatLineModule} from "@angular/material/core";
import {MatCheckboxModule} from "@angular/material/checkbox";
import { MatDialogModule} from "@angular/material/dialog";
import { SignOutDialogComponent } from './sign-out-dialog/sign-out-dialog.component';
import { AddTaskDialogComponent } from './add-task-dialog/add-task-dialog.component';


@NgModule({
  declarations: [
    DashboardComponent,
    SidebarComponent,
    NotificationsComponent,
    UserProfileComponent,
    TasksComponent,
    CardComponent,
    UserProfileFormComponent,
    HeaderComponent,
    SignOutDialogComponent,
    AddTaskDialogComponent,
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatLineModule,
    MatCheckboxModule,
    MatDialogModule,
    FormsModule
  ]
})
export class HomeModule { }
