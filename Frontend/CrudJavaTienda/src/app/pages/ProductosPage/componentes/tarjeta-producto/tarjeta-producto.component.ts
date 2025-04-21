import { Component, EventEmitter, Input, Output } from '@angular/core';
import { productoSelect } from '../../../../../Models/producto.models';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CommonModule } from '@angular/common';
import { ProductoEditarComponent } from '../producto-editar/producto-editar.component';

@Component({
  selector: 'app-tarjeta-producto',
  imports: [CommonModule],
  templateUrl: './tarjeta-producto.component.html',
  styleUrl: './tarjeta-producto.component.css'
})
export class TarjetaProductoComponent {
  @Input() producto!: productoSelect;

  @Output() editar = new EventEmitter<void>();
  @Output() editarProducto = new EventEmitter<productoSelect>();
  @Output() eliminarProducto= new EventEmitter<number>();

  onEditar3() {
    this.editarProducto.emit(this.producto);
  }
  
  eliminar() {
    if (confirm(`¿Estás seguro de eliminar la categoría "${this.producto.productName}"?`)) {
      this.eliminarProducto.emit(this.producto.productId);
    }
  }

}
