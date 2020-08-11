import { Component, OnInit } from '@angular/core';
import { NotificationService } from "./notification.service";
import { ResponseNotifications } from './notification.model';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  responseNotifications: ResponseNotifications;

  constructor( private notificationService: NotificationService) { }

  ngOnInit(): void {
    this.notificationService.getNotifications()
      .subscribe(
        res => this.responseNotifications = res
    )
  }

}
