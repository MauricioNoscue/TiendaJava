import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { idProveedor, productoProveedor, proveedor } from '../Models/proveedores.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/supplier';
  private url2= environment.apiURL + '/api/v1/productSupplier';

  public TraerTodo():Observable<proveedor[]>{
    return this.http.get<proveedor[]>(`${this.urlBase}/todo`);
  }
  public obtenerUltimoProveedor():Observable<idProveedor>{
    return this.http.get<idProveedor>(`${this.urlBase}/ultimoSu`);
  }
  public Crear(proveedorr:proveedor){
    return this.http.post(`${this.urlBase}/register`,proveedorr);
  }

  public crearProductoProveedor(proveedorr:productoProveedor){
    return this.http.post(`${this.url2}/register`,proveedorr);
  }
  public actualizar( proveedorr:proveedor){
    return this.http.put(`${this.urlBase}/update`,proveedorr)

  }

  public Eliminar(id: number) {
    return this.http.delete(`${this.urlBase}/${id}`);
  }

}
