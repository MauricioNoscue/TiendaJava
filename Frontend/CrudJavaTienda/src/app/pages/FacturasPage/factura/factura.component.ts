import { Component, OnInit } from '@angular/core';
import { InvoiceProduct } from '../../../../Models/facturaProducto.models';
import { ProductoFacturaService } from '../../../../service/producto-factura.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-factura',
  imports: [CommonModule],
  templateUrl: './factura.component.html',
  styleUrl: './factura.component.css'
})
export class FacturaComponent implements OnInit{
  invoiceProducts: InvoiceProduct[] = [];

  constructor(private invoiceProductService: ProductoFacturaService) { }

  ngOnInit(): void {
    this.invoiceProductService.getInvoiceProducts().subscribe(data => {
      this.invoiceProducts = data;
    });
  }
}
