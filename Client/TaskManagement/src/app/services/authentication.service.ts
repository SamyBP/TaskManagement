import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SignInDto} from "../dtos/sign-in.dto";
import {Observable, retry} from "rxjs";
import {SignInResponseDto} from "../dtos/sign-in-response.dto";
import {SignUpDto} from "../dtos/sign-up.dto";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private http : HttpClient) {
  }

  public signIn(dto: SignInDto): Observable<SignInResponseDto>  {
    return this.http.post<SignInResponseDto>('http://localhost:8080/app/auth/signin', dto);
  }

  public signUp(dto : SignUpDto) : Observable<any> {
    return this.http.post<any>('http://localhost:8080/app/auth/signup', dto);
  }
}
