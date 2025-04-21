import { Component, EventEmitter, Input, Output } from '@angular/core';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CategoriaService } from '../../../../../service/categoria.service';
import { FormComponent } from '../form/form.component';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
declare var bootstrap: any;

@Component({
  selector: 'app-categoria-editar',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './categoria-editar.component.html',
  styleUrl: './categoria-editar.component.css'
})
export class CategoriaEditarComponent {
  @Input() categoria!: categoriaSelect;
  @Output() categoriaActualizada = new EventEmitter<void>(); // ← NUEVO
  form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private categoriaService: CategoriaService
  ) {}

  ngOnInit() {
    // Inicializa el formulario con los datos de la categoría
    this.form = this.fb.group({
      categoryId: [this.categoria.categoryId],
      name: [this.categoria.name]
    });
  }

  actualizarCategoria() {
    if (this.form.valid) {
      const categoriaActualizada: categoriaSelect = this.form.value;
      this.categoriaService.actualizar(categoriaActualizada).subscribe(() => {
        console.log('Categoría actualizada');
        this.categoriaActualizada.emit();
  
        // Cerrar el modal desde el componente hijo (opcional pero útil)
        const modal = document.getElementById('modalEditarCategoria');
        if (modal) {
          const modalInstance = bootstrap.Modal.getInstance(modal);
          modalInstance?.hide();
        }
      });
    }
  }
  
  
}
