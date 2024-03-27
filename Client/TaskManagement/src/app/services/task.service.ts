import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TaskModel} from "../models/task.model";
import {TaskDto} from "../dtos/task.dto";
import * as http from "http";
import {TaskStatus} from "../models/task-status.model";

@Injectable({
  providedIn : "root"
})
export class TaskService {

  constructor(private http : HttpClient) {
  }

  public getAllTasksForUser(id : number) : Observable<TaskModel[]> {
    return this.http.get<TaskModel[]>(`http://localhost:8080/api/task/all-for-user/${id}`);
  }

  public removeTask(id : number) : Observable<any> {
    return this.http.delete(`http://localhost:8080/api/task/remove-task/${id}`);
  }

  public addTask(userId: number, dto: TaskDto) : Observable<TaskModel> {
    return this.http.post<TaskModel>(`http://localhost:8080/api/task/add-task/${userId}`, dto);
  }

  public updateTaskStatus(taskId: number, status: TaskStatus) : Observable<any> {
    return this.http.patch(`http://localhost:8080/api/task/update-task-status/${taskId}?status=${status}`, {});
  }
}
