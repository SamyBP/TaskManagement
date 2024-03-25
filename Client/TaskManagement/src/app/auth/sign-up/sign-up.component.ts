import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../../services/authentication.service";
import {SignUpDto} from "../../dtos/sign-up.dto";
import {ErrorResponseDto} from "../../dtos/error-response.dto";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent implements OnInit{
  signUpForm!: FormGroup

  constructor(private formBuilder : FormBuilder,
              private authenticationService: AuthenticationService) {
  }
  ngOnInit(): void {

    this.signUpForm = this.formBuilder.group({
      email: ['', Validators.required],
      username: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    console.log(this.signUpForm.value);

    const signUpDto : SignUpDto = {
      email: this.signUpForm.value.email,
      username: this.signUpForm.value.username,
      firstName: this.signUpForm.value.firstName,
      lastName: this.signUpForm.value.lastName,
      password: this.signUpForm.value.password
    };

    this.authenticationService.signUp(signUpDto).subscribe({
      next: () => {
        console.log("Sign up successful");
      },
      error: (error : ErrorResponseDto) => {
        console.log(error.message + error.time);
      }
    });
  }
}
