import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResponseNotifications } from "./notification.model";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private url = "http://localhost:8089/notification/notifications";

  constructor(private http: HttpClient) { }

  getNotifications(): Observable<ResponseNotifications>{
    return this.http.get<ResponseNotifications>(this.url)
  }
}
