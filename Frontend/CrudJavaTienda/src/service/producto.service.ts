import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { productCrear, productoSelect } from '../Models/producto.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/product';

  
  public TraerTodo():Observable<productoSelect[]>{
    return this.http.get<productoSelect[]>(`${this.urlBase}/todo`);
  }

  public Crear(producto:productCrear){
    return this.http.post(`${this.urlBase}/register`,producto);
  }
  public actualizar( producto:productoSelect){
    return this.http.put(`${this.urlBase}/update`,producto)

  }

  public Eliminar(id: number) {
    return this.http.delete(`${this.urlBase}/${id}`);
  }
  buscarPorNombre(nombre: string) {
    const params = new HttpParams().set('name', nombre);
    return this.http.get<productoSelect[]>(`${this.urlBase}/buscar`, { params });
  }
}
