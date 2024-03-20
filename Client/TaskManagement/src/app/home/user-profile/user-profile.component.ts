import { Component } from '@angular/core';
import {TasksComponent} from "../tasks/tasks.component";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {

    protected readonly TasksComponent = TasksComponent;
}
