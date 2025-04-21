import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { categoriaSelect } from '../Models/categoria.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/category';


   public TraerTodo():Observable<categoriaSelect[]>{
      return this.http.get<categoriaSelect[]>(`${this.urlBase}/todo`);
    }

    public Crear(categoria:categoriaSelect){
      return this.http.post(`${this.urlBase}/register`,categoria);
    }
    public actualizar( categoria:categoriaSelect){
      return this.http.put(`${this.urlBase}/update`,categoria)
  
    }

    public Eliminar(id: number) {
      return this.http.delete(`${this.urlBase}/${id}`);
    }
}
