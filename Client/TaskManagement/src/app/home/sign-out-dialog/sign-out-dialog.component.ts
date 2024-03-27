import { Component } from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-out-dialog',
  templateUrl: './sign-out-dialog.component.html',
  styleUrl: './sign-out-dialog.component.css'
})
export class SignOutDialogComponent {
  constructor(public dialogRef: MatDialogRef<SignOutDialogComponent>,
              private router: Router) {}

  onConfirmation(confirmation : boolean) : void {
    if (confirmation) {
      localStorage.clear();
      this.router.navigateByUrl('');
    }
  }

}
