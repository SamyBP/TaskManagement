import {TaskStatus} from "./task-status.model";

export interface TaskModel{
  id : number;
  name: string;
  content: string;
  deadline: string;
  status: TaskStatus;
}
