import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {TokenService} from "../../services/token.service";
import {UserModel} from "../../models/user.model";
import {ErrorResponseDto} from "../../dtos/error-response.dto";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent implements OnInit{
  user!: UserModel;

  constructor(private userService: UserService,
              private tokenService: TokenService) {
  }

  ngOnInit(): void {
    const token = this.tokenService.getAuthToken();
    if (token) {
      const decodedToken = this.tokenService.decodeToken(token);
      this.userService.getUserDetails(decodedToken.id).subscribe({
        next : (response : UserModel) => {
           this.user = response;
           console.log(this.user);
        },
        error : (error : ErrorResponseDto) => {
          console.log(error);
        }
      })
    }
  }

  refresh(refresh:boolean): void {
    if (refresh)
      this.ngOnInit();
  }
}
