import { Injectable } from '@angular/core';
import {Subject} from "rxjs/Subject";
import {NavigationStart, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AlertService {
  private subject = new Subject<any>();
  private keepAfterNavChange = false;

  constructor(private  router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof  NavigationStart) {
        if (this.keepAfterNavChange) {
          this.keepAfterNavChange = false;
        } else {
          this.subject.next();
        }
      }
  }
    );
  }

  success(message: string, keepAfterNavChange = false) {
    this.keepAfterNavChange = keepAfterNavChange;
    this.subject.next({type: 'success', text: message});
  }
  error(message: string, keepAfterNavChange = false) {
    this.keepAfterNavChange = keepAfterNavChange;
    this.subject.next({type: 'error', text: message});
  }
  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }
}
