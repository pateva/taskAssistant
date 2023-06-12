import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewTaskComponent } from './new-task/new-task.component';
import { TaskListingComponent } from './task-listing/task-listing.component';
import { TaskViewComponent } from './task-view/task-view.component';

const routes: Routes = [
  { path: 'task', component: NewTaskComponent },
  { path: 'tasks', component: TaskListingComponent },
  { path: 'task/:id', component: TaskViewComponent },
  { path: '', redirectTo: 'tasks', pathMatch: 'full' },
  { path: '**', redirectTo: 'tasks', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
