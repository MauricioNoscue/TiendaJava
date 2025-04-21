import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { proveedor } from '../../../../../Models/proveedores.models';

@Component({
  selector: 'app-tarjeta-proveedor',
  imports: [CommonModule],
  templateUrl: './tarjeta-proveedor.component.html',
  styleUrl: './tarjeta-proveedor.component.css'
})
export class TarjetaProveedorComponent {

  @Input() proveedorr!: proveedor;

  @Output() editar = new EventEmitter<void>();
  @Output() editarproveedorr = new EventEmitter<proveedor>();
  @Output() eliminarproveedorr= new EventEmitter<number>();

  onEditar3() {
    this.editarproveedorr.emit(this.proveedorr);
  }
  
  eliminar() {
    if (confirm(`¿Estás seguro de eliminar la categoría "${this.proveedorr.supplierName}"?`)) {
      this.eliminarproveedorr.emit(this.proveedorr.supplierID);
    }
  }

}
