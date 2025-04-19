import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from './environments/environment.development';
import { Person, PersonCreation } from './person.models';

@Injectable({
  providedIn: 'root'
})
export class PersonServiceService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/Person';

  public Login(person:PersonCreation){
    return this.http.post(`${this.urlBase}/login`,person);
  }


  public TraerTodo():Observable<Person[]>{
    return this.http.get<Person[]>(this.urlBase);
  }

  public obtenerPorId(id:number):Observable<Person>{
    return this.http.get<Person>(`${this.urlBase}/${id}`)
  }
  public Crear(person:PersonCreation){
    return this.http.post(this.urlBase,person);
  }

  public actualizarIdNombre( person:Person){
    return this.http.put(`${this.urlBase}`,person)

  }
  public eliminar(id: number) {
    return this.http.delete(`${this.urlBase}/permanent/${id}`);
  }
}
