import { CategoriaEditarComponent } from './../../CateoriaPage/componentes/categoria-editar/categoria-editar.component';
import { Component, OnInit } from '@angular/core';
import { productoSelect } from '../../../../Models/producto.models';
import { ProductoService } from '../../../../service/producto.service';
import { TarjetaProductoComponent } from "../componentes/tarjeta-producto/tarjeta-producto.component";
import { CommonModule } from '@angular/common';
import { ProductoEditarComponent } from '../componentes/producto-editar/producto-editar.component';
import { ProductoCrearComponent } from "../componentes/producto-crear/producto-crear.component";


declare var bootstrap: any;
@Component({
  selector: 'app-producto',

  imports: [ProductoEditarComponent, TarjetaProductoComponent, CommonModule, ProductoCrearComponent],
  templateUrl: './producto.component.html',
  styleUrl: './producto.component.css'
})
export class ProductoComponent  implements OnInit{
  productoSeleccionada!: productoSelect | null;
  modalEditarRef: any = null;
  modalCrearRef: any = null; 
  cards: productoSelect[] = [];

  constructor (private productoService: ProductoService) {}
  
  ngOnInit(): void {
    this.productoService.TraerTodo().subscribe({
      next: (data) => {
        this.cards = data;
        console.log(data)
      },
      error: (err) => {
        console.error('Error al obtener categorías', err);
      }
    });
  }

  onEditarCategoria(Producto: productoSelect) {
    this.productoSeleccionada = null; // Limpiamos primero
        
          // Esperamos un poco para que Angular detecte el cambio
          setTimeout(() => {
            this.productoSeleccionada = { ...Producto }; // Nueva categoría
            const modal = document.getElementById('modalEditarProducto');
      if (modal) {
        this.modalEditarRef = new bootstrap.Modal(modal);
        this.modalEditarRef.show();
      }

    });
  }

  recargarProductos() {
    this.productoService.TraerTodo().subscribe({
      next: (data) => this.cards = data,
      error: (err) => console.error('Error al obtener categorías', err),
     
    });

    console.log("se recargo")
  }


  recargarProductosYCerrarModal() {
    this.recargarProductos();
  
    if (this.modalEditarRef) {
      this.modalEditarRef.hide();
      this.modalEditarRef = null;
  
      // Esperamos un pequeño tiempo para asegurarnos que el DOM esté actualizado
      setTimeout(() => {
        const backdrop = document.querySelector('.modal-backdrop');
        if (backdrop) {
          backdrop.remove();
        }
  
        // Eliminar clases que Bootstrap agrega al body
        document.body.classList.remove('modal-open');
        document.body.style.removeProperty('padding-right');
      }, 300); // 300ms suele ser suficiente para que el modal se haya ocultado
    }
  }


  recargarProductosYCerrarModalCrear() {
    this.recargarProductos();
  
    if (this.modalCrearRef) {
      this.modalCrearRef.hide();
      this.modalCrearRef = null;
  
      setTimeout(() => {
        const backdrop = document.querySelector('.modal-backdrop');
        if (backdrop) {
          backdrop.remove();
        }
        document.body.classList.remove('modal-open');
        document.body.style.removeProperty('padding-right');
      }, 300);
    }
  }
  ngAfterViewInit() {
    const modalCrear = document.getElementById('modalCrearProducto');
    if (modalCrear) {
      this.modalCrearRef = new bootstrap.Modal(modalCrear);
    }
  }

  eliminarCategoria(id: number) {
    this.productoService.Eliminar(id).subscribe({
      next: () => {
        console.log('Categoría eliminada');
        this.recargarProductos();
      },
      error: (err) => {
        console.error('Error al eliminar categoría', err);
      }
    });
  }
}
