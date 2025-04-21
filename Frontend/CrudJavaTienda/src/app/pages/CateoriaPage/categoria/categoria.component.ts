import { Component, OnInit } from '@angular/core';
import { categoriaSelect } from '../../../../Models/categoria.models';
import { CategoriaService } from '../../../../service/categoria.service';
import { CommonModule } from '@angular/common';
import { CategoriaTarjetaComponent } from '../componentes/categoria-tarjeta/categoria-tarjeta.component';
import { CategoriaCrearComponent } from '../componentes/categoria-crear/categoria-crear.component';
import { CategoriaEditarComponent } from '../componentes/categoria-editar/categoria-editar.component';
import { RolService } from '../../../../service/rol.service';
declare var bootstrap: any;


@Component({
  selector: 'app-categoria',
  imports: [CommonModule,CategoriaTarjetaComponent,CategoriaCrearComponent,CategoriaEditarComponent],
  templateUrl: './categoria.component.html',
  styleUrl: './categoria.component.css'
})
export class CategoriaComponent implements OnInit {
  categoriaSeleccionada!: categoriaSelect | null;
  modalEditarRef: any = null;
  modalCrearRef: any = null; // Agrega esto junto a modalEditarRef
  cards: categoriaSelect[] = [];
  esAdmin: boolean = false;
  constructor(private categoriaService: CategoriaService,private rolService: RolService) {}
  

  ngOnInit(): void {
    this.categoriaService.TraerTodo().subscribe({
      next: (data) => {
        this.cards = data;
        console.log(data)
      },
      error: (err) => {
        console.error('Error al obtener categorías', err);
      }
    });
    this.rolService.esAdministrador().subscribe(esAdmin => {
      this.esAdmin = esAdmin;
    });
  }

  onEditarCategoria(categoria: categoriaSelect) {
    this.categoriaSeleccionada = null; // Limpiamos primero
  
    // Esperamos un poco para que Angular detecte el cambio
    setTimeout(() => {
      this.categoriaSeleccionada = { ...categoria }; // Nueva categoría
      const modal = document.getElementById('modalEditarCategoria');
if (modal) {
  this.modalEditarRef = new bootstrap.Modal(modal);
  this.modalEditarRef.show();
}

    });
  }

  recargarCategorias() {
    this.categoriaService.TraerTodo().subscribe({
      next: (data) => this.cards = data,
      error: (err) => console.error('Error al obtener categorías', err),
     
    });

    console.log("se recargo")
  }
  
  recargarCategoriasYCerrarModal() {
    this.recargarCategorias();
  
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
  
  recargarCategoriasYCerrarModalCrear() {
    this.recargarCategorias();
  
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
    const modalCrear = document.getElementById('modalCrearCategoria');
    if (modalCrear) {
      this.modalCrearRef = new bootstrap.Modal(modalCrear);
    }
  }
  
  eliminarCategoria(id: number) {
    this.categoriaService.Eliminar(id).subscribe({
      next: () => {
        console.log('Categoría eliminada');
        this.recargarCategorias();
      },
      error: (err) => {
        console.error('Error al eliminar categoría', err);
      }
    });
  }
  
  
}
