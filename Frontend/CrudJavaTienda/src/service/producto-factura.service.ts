import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';
import { InvoiceProduct } from '../Models/facturaProducto.models';

@Injectable({
  providedIn: 'root'
})
export class ProductoFacturaService {

  constructor() { }
    private http = inject(HttpClient);
  private urlBase = environment.apiURL + '/api/v1/invoicesProduct/todo'
  getInvoiceProducts(): Observable<InvoiceProduct[]> {
    return this.http.get<InvoiceProduct[]>(this.urlBase);
  }
}
