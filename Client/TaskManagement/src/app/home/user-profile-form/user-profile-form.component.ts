import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-user-profile-form',
  templateUrl: './user-profile-form.component.html',
  styleUrl: './user-profile-form.component.css'
})
export class UserProfileFormComponent implements OnInit{

  profileForm! : FormGroup;

  constructor(private formBuilder : FormBuilder,
              private snackBar: MatSnackBar) {
  }
  ngOnInit(): void {
    this.profileForm = this.formBuilder.group({
      username: ['', !Validators],
      email: ['', Validators.pattern("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")],
      firstName: ['', !Validators],
      lastName: ['', !Validators],
      address: ['', !Validators],
      city: ['', !Validators],
      country: ['', !Validators],
      phoneNumber: ['', !Validators],
      postalCode: ['', !Validators],
    })
  }

  onSubmit() : void {

  }

  openSnackbar(message : string) : void {
    this.snackBar.open(message, "ok");
  }
}
