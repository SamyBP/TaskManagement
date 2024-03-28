import {Component, OnInit} from '@angular/core';
import {TaskModel} from "../../models/task.model";
import {TaskService} from "../../services/task.service";
import {TokenService} from "../../services/token.service";
import {ErrorResponseDto} from "../../dtos/error-response.dto";
import {MatSnackBar} from "@angular/material/snack-bar";
import {TaskStatus} from "../../models/task-status.model";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent implements OnInit{
  tasks!: TaskModel[];
  constructor(private taskService : TaskService,
              private tokenService : TokenService,
              private snackBar : MatSnackBar) {
  }

  ngOnInit(): void  {
    const token = this.tokenService.getAuthToken();
    if (token) {
      const decodedToken = this.tokenService.decodeToken(token);
      this.taskService.getAllTasksForUser(decodedToken.id).subscribe({
        next : (response : TaskModel[]) => {
          this.tasks = response;
          console.log(this.tasks);
        },
        error : (error : ErrorResponseDto) => {
          console.log(error);
        }
      })
    }
  }

  deleteTask(task : TaskModel) : void {
    this.taskService.removeTask(task.id).subscribe({
      next: () => {
        let snackBarRef = this.snackBar.open("Removed successfully", "Ok");

        snackBarRef.onAction().subscribe(() => {
          this.ngOnInit()
        });
      },
      error: (error : ErrorResponseDto) => {
        let snackBarRef = this.snackBar.open("Something went wrong", "Ok");

        snackBarRef.onAction().subscribe(() => {
          this.ngOnInit();
        });
        console.log(error);
      }
    })
  }

  updateTaskStatus(task : TaskModel, event : any) : void {
    const newTaskStatus = event.target.textContent.trim();
    task.status = newTaskStatus;
    console.log(newTaskStatus);
  }

  editTaskStatus(task : TaskModel) : void {

    this.taskService.updateTaskStatus(task.id, task.status).subscribe({
      next: () => {
        console.log("Updated task status");
        this.ngOnInit();
      },
      error: (error : ErrorResponseDto) => {
        console.log(error);
      }
    })

    console.log(task);
  }

  getHeaderColor(task : TaskModel) : string {
    switch (task.status) {
      case TaskStatus.TODO:
        return 'purple';
      case TaskStatus.IN_PROGRESS:
        return 'lightblue';
      case TaskStatus.COMPLETED:
        return  'greenyellow';
    }
  }
}
