import { Injectable } from '@angular/core';
import { AccessCode, Queue } from '../../shared/models/interfaces';

@Injectable()
export class AuthService {

  private logged = false;
  private accessCode: AccessCode;
  private queue: Queue;

  constructor() { }

  public isLogged(): boolean {
    return this.logged;
  }

  public setLogged(logged: boolean): void {
    this.logged = logged;
    localStorage.setItem('isLogged', String(logged));
  }

  public getAccessCode(): AccessCode {
    return this.accessCode;
  }

  public setAccessCode(accessCode: AccessCode): void {
    this.accessCode = accessCode;
    localStorage.setItem('accessCode', JSON.stringify(accessCode));
  }

  public getQueue(): Queue {
    return this.queue;
  }

  public setQueue(queue: Queue): void {
    this.queue = queue;
    localStorage.setItem('queue', JSON.stringify(queue));
  }

  public regenerateSession() {
    const isLogged = (localStorage.getItem('isLogged') && localStorage.getItem('isLogged') === 'true');

    if (!isLogged) {
      return false;
    }

    this.setLogged(true);
    this.setAccessCode(JSON.parse(localStorage.getItem('accessCode')));
    this.setQueue(JSON.parse(localStorage.getItem('queue')));
  }
}
