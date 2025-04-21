import { Component, EventEmitter, Input, Output } from '@angular/core';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CommonModule } from '@angular/common';
import { CategoriaEditarComponent } from '../categoria-editar/categoria-editar.component';

@Component({
  selector: 'app-categoria-tarjeta',
  imports: [CommonModule],
  templateUrl: './categoria-tarjeta.component.html',
  styleUrl: './categoria-tarjeta.component.css'
})
export class CategoriaTarjetaComponent {

  @Input() categoria!: categoriaSelect;

  @Output() editar = new EventEmitter<void>();
  @Output() editarCategoria = new EventEmitter<categoriaSelect>();
  @Output() eliminarCategoria = new EventEmitter<number>();
  
  onEditar3() {
    this.editarCategoria.emit(this.categoria);
  }
  
  eliminar() {
    if (confirm(`¿Estás seguro de eliminar la categoría "${this.categoria.name}"?`)) {
      this.eliminarCategoria.emit(this.categoria.categoryId);
    }
  }
}
