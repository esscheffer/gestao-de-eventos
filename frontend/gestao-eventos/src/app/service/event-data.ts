import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventDataService {
  private apiUrl = 'http://backend:8080/api/events?page=0&size=100';
  private byIdUrl = 'http://backend:8080/api/events/';

  constructor(private http: HttpClient) { }

  getEvents(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getEventById(id: string): Observable<any> {
    return this.http.get(`${this.byIdUrl}${id}`);
  }
}
