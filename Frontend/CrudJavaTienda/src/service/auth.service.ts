// shared/auth.service.ts
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { userCreate } from '../Models/user.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject = new BehaviorSubject<any>(null);
  public currentUser = this.currentUserSubject.asObservable();

  constructor() {
    // Intenta recuperar usuario del localStorage al iniciar
    const storedUser = localStorage.getItem('currentUser');
    if (storedUser) {
      this.currentUserSubject.next(JSON.parse(storedUser));
    }
  }

  setCurrentUser(user: any) {
    // Guarda en localStorage y en el observable
    localStorage.setItem('currentUser', JSON.stringify(user));
    this.currentUserSubject.next(user);
  }

  getCurrentUser() {
    return this.currentUserSubject.value;
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}