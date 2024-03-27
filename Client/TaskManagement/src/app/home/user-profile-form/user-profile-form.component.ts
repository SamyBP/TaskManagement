import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {UserEditDto} from "../../dtos/user-edit.dto";
import {UserService} from "../../services/user.service";
import {TokenService} from "../../services/token.service";
import {HttpStatusCode} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-profile-form',
  templateUrl: './user-profile-form.component.html',
  styleUrl: './user-profile-form.component.css'
})
export class UserProfileFormComponent implements OnInit{
  @Output() refresh = new EventEmitter<boolean>;
  profileForm!: FormGroup;

  constructor(private formBuilder : FormBuilder,
              private snackBar: MatSnackBar,
              private userService : UserService,
              private tokenService : TokenService) {
  }
  ngOnInit(): void {
    this.profileForm = this.formBuilder.group({
      username: ['', !Validators],
      email: ['', !Validators],
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
    const userEditDto : UserEditDto = {
      username : this.profileForm.value.username,
      email : this.profileForm.value.email,
      firstName : this.profileForm.value.firstName,
      lastName : this.profileForm.value.lastName,
      address : this.profileForm.value.address,
      city : this.profileForm.value.city,
      country : this.profileForm.value.country,
      phoneNumber : this.profileForm.value.phoneNumber,
      postalCode : this.profileForm.value.postalCode,
    }

    const token = this.tokenService.getAuthToken();

    if (token) {
      const decodedToken : any = this.tokenService.decodeToken(token);
      const userId : number = decodedToken.id;
      this.userService.editUserProfile(userId, userEditDto).subscribe({
        next : (statusCode : HttpStatusCode) => {
          let snackBarRef = this.snackBar.open("Edited profile", "Ok");

          snackBarRef.onAction().subscribe(() => {
            this.refresh.emit(true);
          });
        },
        error : (error : HttpStatusCode) => {
          let snackBarRef = this.snackBar.open("Something went wrong", "Ok");

          snackBarRef.onAction().subscribe(() => {
            this.refresh.emit(true);
          });
        }
      })
    }
  }
}
