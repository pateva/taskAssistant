import { Component } from '@angular/core';
import { Task } from '../interfaces/task';

@Component({
  selector: 'tma-task-listing',
  templateUrl: './task-listing.component.html',
  styleUrls: ['./task-listing.component.scss']
})
export class TaskListingComponent {
  tasks: Task[] = [
    {
      taskId: 1,
      taskTitel: 'Task 1',
      taskDescription: 'Description for Task 1'
    },
    {
      taskId: 2,
      taskTitel: 'Task 2',
      taskDescription: 'Description for Task 2'
    },
    {
      taskId: 3,
      taskTitel: 'Task 3',
      taskDescription: 'Description for Task 3'
    }
  ];

}
