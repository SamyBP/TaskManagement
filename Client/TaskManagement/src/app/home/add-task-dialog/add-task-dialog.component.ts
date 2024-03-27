import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TaskService} from "../../services/task.service";
import {TokenService} from "../../services/token.service";
import {TaskDto} from "../../dtos/task.dto";
import {TaskModel} from "../../models/task.model";
import {ErrorResponseDto} from "../../dtos/error-response.dto";

@Component({
  selector: 'app-add-task-dialog',
  templateUrl: './add-task-dialog.component.html',
  styleUrl: './add-task-dialog.component.css'
})
export class AddTaskDialogComponent implements OnInit{

  addTaskForm! : FormGroup;

  constructor(public dialogRef: MatDialogRef<AddTaskDialogComponent>,
              private formBuilder: FormBuilder,
              private taskService: TaskService,
              private tokenService: TokenService) {}

  ngOnInit(): void {
    this.addTaskForm = this.formBuilder.group({
      name: ['', Validators.required],
      content: ['', Validators.required],
      deadline: ['', Validators.required]
    })
  }

  addTask() {
      const token = this.tokenService.getAuthToken();
      if (token) {
        const decodedToken = this.tokenService.decodeToken(token);
        const dto : TaskDto = {
          name: this.addTaskForm.value.name,
          content: this.addTaskForm.value.content,
          deadline: this.addTaskForm.value.deadline
        }

        console.log(dto);

        this.taskService.addTask(decodedToken.id, dto).subscribe({
          next : (response : TaskModel) => {
            console.log(response);
          },
          error: (error : ErrorResponseDto) => {
            console.log(error);
          }
        });
      }
  }
}
