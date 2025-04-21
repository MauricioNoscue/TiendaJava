import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { environment } from '../environments/environment.development';
import { PersonCreated } from '../Models/person.models';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/person';

  public Login(person:PersonCreated){
    return this.http.post(`${this.urlBase}/register`,person);
  }

}
