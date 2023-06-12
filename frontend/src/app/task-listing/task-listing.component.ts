import { Component } from '@angular/core';
import { Task } from '../interfaces/task';
import { Router } from '@angular/router';
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

  constructor(private dataService: DataService,
    private router: Router) {
  }
  
  ngOnInit() {
    this.dataService.getAllTasks().subscribe(
      result => {
        this.tasks = result;
        console.log(this.tasks)
      },
      error => {
        this.onHttpError(error);
      }
    );
  }

  onHttpError(errorResponse: any) {
    console.log("Error: ", errorResponse);
    this.postError = true;
    this.postErrorMessage = errorResponse.error?.errorMessage;
  }

  updateTask(task: Task) {
    console.log("something happened");
    // Call your data service's updateTask() method to send the PUT request
    // this.dataService.updateTask(task).subscribe(
    //   response => {
    //     // Handle the response after successful update
    //     console.log('Task updated successfully', response);
    //   },
    //   error => {
    //     // Handle any errors that occur during the update
    //     console.error('Error updating task', error);
    //   }
    // );
  }

  editTask(task: Task) {
    console.log("edit task");
  }

}
