import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Task } from '../interfaces/task';
import { DataService } from '../data/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'tma-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.scss']
})
export class NewTaskComponent {
  title = '';
  description = '';
  postError = false;
  postErrorMessage = '';
  isLoading = true;

  constructor(private dataService: DataService,
    private router: Router,) {}

 
  onSubmit(form: NgForm) {
    if (form.valid) {
      const newTask: Task = {
        taskId: 0,
        title: this.title,
        description: this.description
      };
      console.log("In onSubmit: ", form.valid);

      this.dataService.postTask(newTask).subscribe(
        result => {
          console.log("Success: ", result);
          this.router.navigateByUrl(`/task/${result.taskId}`);
        },
        error => {
          this.onHttpError(error);
        }
      );
    }
  }

  onHttpError(errorResponse: any) {
    console.log("Error: ", errorResponse);
    this.postError = true;
    this.postErrorMessage = errorResponse.error?.errorMessage;
  }
}
