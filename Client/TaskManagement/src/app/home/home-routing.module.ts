import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from "./dashboard/dashboard.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { NotificationsComponent } from "./notifications/notifications.component";
import { TasksComponent } from "./tasks/tasks.component";

const routes: Routes = [
  { path : 'app/home/dashboard', component : DashboardComponent },
  { path : 'app/home/user-profile', component : UserProfileComponent },
  { path : 'app/home/notifications', component : NotificationsComponent },
  { path : 'app/home/tasks', component : TasksComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
