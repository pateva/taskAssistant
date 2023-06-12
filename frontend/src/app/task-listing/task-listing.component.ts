import { Component } from '@angular/core';
import { Task } from '../interfaces/task';
import { DataService } from '../data/data.service';

@Component({
  selector: 'tma-task-listing',
  templateUrl: './task-listing.component.html',
  styleUrls: ['./task-listing.component.scss']
})
export class TaskListingComponent {
  tasks: Task[] = [];
  postError = false;
  postErrorMessage = '';
  isLoading = true;

  constructor(private dataService: DataService,) {
  }
  
  ngOnInit() {
    this.listTasks();
    this.isLoading = false;
  }

  onHttpError(errorResponse: any) {
    console.log("Error: ", errorResponse);
    this.postError = true;
    this.postErrorMessage = errorResponse.error?.errorMessage;
  }

  updateTask(task: Task) {
    console.log("something happened");
    this.dataService.putTaskAsDone(task).subscribe(
      result => {
        console.log("Task is marked as done");
        this.listTasks();
        this.isLoading = false;
      },
      error => {
        this.onHttpError(error);
        this.isLoading = false;
      }
    );
  }

  editTask(task: Task) {
    console.log("edit task");
  }

  exportTasks() {
    this.dataService.exportAllTasks().subscribe(
      result => {
        console.log("Tasks are exported!");
      },
      error => {
        this.onHttpError(error);
      }
    );
  }

  listTasks() {
    this.dataService.getAllTasks().subscribe(
      result => {
        this.tasks = result;
      },
      error => {
        this.onHttpError(error);
      }
    );
  }

};

