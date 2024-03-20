import {Injectable} from "@angular/core";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn : "root"
})
export class TokenService {
  constructor(private jwtHelper : JwtHelperService) {
  }

  public decodeToken(token : any) : any {
    return this.jwtHelper.decodeToken(token);
  }
}
