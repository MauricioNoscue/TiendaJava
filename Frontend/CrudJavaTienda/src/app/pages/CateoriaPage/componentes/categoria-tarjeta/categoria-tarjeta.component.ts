import { Component, EventEmitter, Input, Output } from '@angular/core';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CommonModule } from '@angular/common';
import { CategoriaEditarComponent } from '../categoria-editar/categoria-editar.component';
import { RolService } from '../../../../../service/rol.service';

@Component({
  selector: 'app-categoria-tarjeta',
  imports: [CommonModule],
  templateUrl: './categoria-tarjeta.component.html',
  styleUrl: './categoria-tarjeta.component.css'
})
export class CategoriaTarjetaComponent {

  @Input() categoria!: categoriaSelect;
  esAdmin: boolean = false;
  @Output() editar = new EventEmitter<void>();
  @Output() editarCategoria = new EventEmitter<categoriaSelect>();
  @Output() eliminarCategoria = new EventEmitter<number>();

  constructor(private rolService: RolService) {}

  onEditar3() {
    this.editarCategoria.emit(this.categoria);
  }
  ngOnInit(): void {
    // Suscribirse al observable de rol
    this.rolService.esAdministrador().subscribe(esAdmin => {
      this.esAdmin = esAdmin;
    });
    
    // Cargar productos

  }

 

  
  eliminar() {
    if (confirm(`¿Estás seguro de eliminar la categoría "${this.categoria.name}"?`)) {
      this.eliminarCategoria.emit(this.categoria.categoryId);
    }
  }
}
