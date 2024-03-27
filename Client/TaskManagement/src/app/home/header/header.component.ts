import {Component, Input} from '@angular/core';
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {SignOutDialogComponent} from "../sign-out-dialog/sign-out-dialog.component";
import {AddTaskDialogComponent} from "../add-task-dialog/add-task-dialog.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  @Input() showAddButton!: boolean
  @Input() signOutStyle!: string;

  constructor(private router : Router, public dialog: MatDialog) {
  }
  openSignOutDialog() : void {
    this.dialog.open(SignOutDialogComponent, {
      width: '250px'
    });
  }

  openAddTaskDialog() : void {
    this.dialog.open(AddTaskDialogComponent, {
      width: '500px'
    })
  }
}
