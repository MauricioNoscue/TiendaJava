import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { login, peronid, user, userCreate } from '../Models/user.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/Users';

  
  public register(user:userCreate){
    return this.http.post(`${this.urlBase}/register`,user);
  }

  public ultimaPersona():Observable<peronid>{
    return this.http.get<peronid>(`${this.urlBase}/ultimaPersona`);
  }
   
  public TraerTodo():Observable<user[]>{
    return this.http.get<user[]>(`${this.urlBase}/todo`);
  }

    public Login(userr:login){
      return this.http.post(`${this.urlBase}/login`,userr);
    }
  

}
