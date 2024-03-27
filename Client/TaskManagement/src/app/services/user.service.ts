import {Injectable} from "@angular/core";
import {HttpClient, HttpStatusCode} from "@angular/common/http";
import {UserEditDto} from "../dtos/user-edit.dto";
import {Observable} from "rxjs";
import {UserModel} from "../models/user.model";

@Injectable({
  providedIn : "root"
})
export class UserService {
  constructor(private http : HttpClient) {
  }

  public editUserProfile(id : number, dto : UserEditDto) : Observable<HttpStatusCode> {
    return this.http.put<HttpStatusCode>(`http://localhost:8080/api/user/update/${id}`, dto);
  }

  public getUserDetails(id : number) : Observable<UserModel> {
    return this.http.get<UserModel>(`http://localhost:8080/api/user/details/${id}`);
  }
}
