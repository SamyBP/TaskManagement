import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../../services/authentication.service";
import {SignInDto} from "../../dtos/sign-in.dto";
import {SignInResponseDto} from "../../dtos/sign-in-response.dto";
import {ErrorResponseDto} from "../../dtos/error-response.dto";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent implements OnInit{
  signInForm! : FormGroup
  errorMessage! : string;

  constructor(private formBuilder : FormBuilder,
              private authenticationService : AuthenticationService,
              private router : Router) {
  }

  ngOnInit(): void {

    this.signInForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  onSubmit(): void {
    console.log(this.signInForm.value);

    const signInDto : SignInDto = {
      email : this.signInForm.value.email,
      password : this.signInForm.value.password
    };

    this.authenticationService.signIn(signInDto).subscribe({
      next : (response : SignInResponseDto) => {
        console.log("Sign in successful!");
        localStorage.setItem("token", response.token);
        this.router.navigateByUrl("/app/home/dashboard");
      },
      error : (error : ErrorResponseDto) => {
        console.log(error.statusCode);
        this.errorMessage = error.message;
      }
    });
  }
}
