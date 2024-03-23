import {Injectable} from "@angular/core";
import {HttpClient, HttpStatusCode} from "@angular/common/http";
import {UserEditDto} from "../dtos/user-edit.dto";
import {Observable} from "rxjs";

@Injectable({
  providedIn : "root"
})
export class UserService {
  constructor(private http : HttpClient) {
  }

  public editUserProfile(id : number, dto : UserEditDto) : Observable<HttpStatusCode> {
    return this.http.put<HttpStatusCode>(`http://localhost:8080/app/user/edit-profile/${id}`, dto);
  }
}
