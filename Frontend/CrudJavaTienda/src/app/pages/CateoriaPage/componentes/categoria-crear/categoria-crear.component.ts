import { Component, EventEmitter, importProvidersFrom, Output } from '@angular/core';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CategoriaService } from '../../../../../service/categoria.service';
import { FormComponent } from '../form/form.component';


@Component({
  selector: 'app-categoria-crear',
  imports: [FormComponent],
  templateUrl: './categoria-crear.component.html',
  styleUrl: './categoria-crear.component.css'
})
export class CategoriaCrearComponent {
  @Output() categoriaActualizada = new EventEmitter<void>();
  constructor(private categoriaService: CategoriaService) {}

  crearCategoria(categoria: categoriaSelect) {
    this.categoriaService.Crear(categoria).subscribe(() => {
      console.log('Categoría creada');
      this.categoriaActualizada.emit();
    });
  }
}
