import { Injectable } from '@angular/core';
import { Task } from '../interfaces/task';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  baseUrl = 'http://localhost:8080/tasks';

  constructor(private http: HttpClient) { }

  getAllTasks(): Observable<Task[]> {

    return this.http.get<Task[]>(this.baseUrl);
  }

  exportAllTasks(): Observable<any> {

    return this.http.get<any>(this.baseUrl + "?isToFile=true");
  }

  getTaskById(taskId: number): Observable<Task> {
    return this.http.get<Task>(this.baseUrl + `/${taskId}`);
  }

  postTask(task: Task): Observable<Task> {

    return this.http.post<Task>(this.baseUrl, task);
  }

  putTaskAsDone(task: Task): Observable<Task> {

    const url = this.baseUrl + "/"+ task.taskId + "?isInactive=true";

    return this.http.put<Task>(url, task);
  }

}
