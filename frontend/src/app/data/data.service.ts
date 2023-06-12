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

  getAllImages(): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl);
  }
}
