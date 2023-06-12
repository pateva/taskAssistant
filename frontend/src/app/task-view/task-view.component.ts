import { Component } from '@angular/core';
import { DataService } from '../data/data.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'tma-task-view',
  templateUrl: './task-view.component.html',
  styleUrls: ['./task-view.component.scss']
})
export class TaskViewComponent {
  description = '';
  title = '';
  taskId = 0;
  postError: boolean = false;
  postErrorMessage: any;

  constructor(private dataService: DataService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.taskId = params['id'];
    })

    console.log("id = " + this.taskId);
    this.dataService.getTaskById(this.taskId).subscribe(
      result => {
        this.description = result.description;
        this.title = result.title;
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

}
