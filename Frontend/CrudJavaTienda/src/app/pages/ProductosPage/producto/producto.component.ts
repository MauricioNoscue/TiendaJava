import { FormsModule } from '@angular/forms';
import { CategoriaEditarComponent } from './../../CateoriaPage/componentes/categoria-editar/categoria-editar.component';
import { Component, OnInit } from '@angular/core';
import { productoSelect } from '../../../../Models/producto.models';
import { ProductoService } from '../../../../service/producto.service';
import { TarjetaProductoComponent } from "../componentes/tarjeta-producto/tarjeta-producto.component";
import { CommonModule } from '@angular/common';
import { ProductoEditarComponent } from '../componentes/producto-editar/producto-editar.component';
import { ProductoCrearComponent } from "../componentes/producto-crear/producto-crear.component";
import { RolService } from '../../../../service/rol.service';
import { categoriaSelect } from '../../../../Models/categoria.models';
import { CategoriaService } from '../../../../service/categoria.service';

declare var bootstrap: any;
@Component({
  selector: 'app-producto',
  imports: [ProductoEditarComponent, TarjetaProductoComponent, CommonModule, ProductoCrearComponent, FormsModule],
  templateUrl: './producto.component.html',
  styleUrl: './producto.component.css'
})
export class ProductoComponent implements OnInit {
  productoSeleccionada!: productoSelect | null;
  modalEditarRef: any = null;
  modalCrearRef: any = null; 
  cards: productoSelect[] = [];
  todosLosProductos: productoSelect[] = []; // Para guardar todos los productos sin filtrar
  esAdmin: boolean = false;
  categorias: categoriaSelect[] = []; // Para almacenar las categorías
  categoriaSeleccionada: number = 0; // 0 significa "todas las categorías"
  termBusqueda: string = ''; 
  
  constructor(
    private productoService: ProductoService,
    private rolService: RolService,
    private categoriaService: CategoriaService // Servicio de categorías
  ) {}
  
  ngOnInit(): void {
    this.cargarCategorias();
    this.cargarProductos();
    
    this.rolService.esAdministrador().subscribe(esAdmin => {
      this.esAdmin = esAdmin;
    });
  }
  
  buscarProductos() {
    if (!this.termBusqueda.trim()) {
      // Si el campo de búsqueda está vacío, mostrar todos los productos
      this.cargarProductos();
      return;
    }
    
    // Llamar al servicio para buscar productos por nombre
    this.productoService.buscarPorNombre(this.termBusqueda).subscribe({
      next: (data) => {
        this.todosLosProductos = data; // Actualizamos la lista completa
        this.cards = data; // Mostramos los resultados
      },
      error: (err) => {
        console.error('Error al buscar productos', err);
      }
    });
  }

  cargarCategorias() {
    this.categoriaService.TraerTodo().subscribe({
      next: (data) => {
        this.categorias = data;
      },
      error: (err) => {
        console.error('Error al obtener categorías', err);
      }
    });
  }
  
  cargarProductos() {
    this.productoService.TraerTodo().subscribe({
      next: (data) => {
        this.todosLosProductos = data; // Guardamos todos los productos
        this.cards = data; // Inicialmente mostramos todos
        console.log(data);
      },
      error: (err) => {
        console.error('Error al obtener productos', err);
      }
    });
  }
  
  filtrarProductos() {
    if (this.categoriaSeleccionada == 0) {
      // Si es "todas las categorías", mostramos todos los productos
      this.cards = [...this.todosLosProductos];
    } else {
      // Filtramos por la categoría seleccionada
      this.cards = this.todosLosProductos.filter(
        producto => producto.category?.categoryId == this.categoriaSeleccionada
      );
    }
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
      next: (data) => {
        this.todosLosProductos = data; // Actualizamos todos los productos
        // Aplicamos el filtro actual
        this.filtrarProductos();
      },
      error: (err) => console.error('Error al obtener productos', err),
    });
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