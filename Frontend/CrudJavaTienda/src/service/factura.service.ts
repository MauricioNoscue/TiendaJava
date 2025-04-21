import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { factura, facturaId, facturaProducto } from '../Models/factura.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor() { }
  private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/invoices';
  private url2 = environment.apiURL + '/api/v1/invoicesProduct';

   public TraerTodo():Observable<factura[]>{
        return this.http.get<factura[]>(`${this.urlBase}/todo`);
      }

      crearFactura(factura: factura) {
        return this.http.post<factura>(`${this.urlBase}/register`, factura);
      }
      
      obtenerUltimaFactura() :Observable<facturaId>{
        return this.http.get<facturaId>(`${this.urlBase}/ultimo`);
      }
    
      
      agregarProductoAFactura(data: facturaProducto) {
        return this.http.post(`${this.url2}/register`, data);
      }
      
}
