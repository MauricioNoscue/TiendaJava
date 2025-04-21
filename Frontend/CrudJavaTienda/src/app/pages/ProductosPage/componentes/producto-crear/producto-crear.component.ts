import { Component, EventEmitter, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CategoriaService } from '../../../../../service/categoria.service';
import { CommonModule } from '@angular/common';
import { ProductoService } from '../../../../../service/producto.service';
import { productCrear } from '../../../../../Models/producto.models';

@Component({
  selector: 'app-producto-crear',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './producto-crear.component.html',
  styleUrl: './producto-crear.component.css'
})
export class ProductoCrearComponent {
  @Output() productoCreado = new EventEmitter<void>();
  
  form: FormGroup;
  categorias: categoriaSelect[] = [];
  
  constructor(
    private fb: FormBuilder,
    private productoService: ProductoService,
    private categoriaService: CategoriaService
  ) {
    this.form = this.fb.group({
      productName: ['', Validators.required],
      description: ['', Validators.required],
      productPrice: [0, [Validators.required, Validators.min(0)]],
      categoryId: [null, Validators.required]
    });
    
    this.cargarCategorias();
  }
  
  cargarCategorias() {
    this.categoriaService.TraerTodo().subscribe(categorias => {
      this.categorias = categorias;
    });
  }
  
  onSubmit() {
    if (this.form.valid) {
      const producto: productCrear = {
        productName: this.form.value.productName,
        description: this.form.value.description,
        productPrice: this.form.value.productPrice,
        categoryId: this.form.value.categoryId
      };
      
      this.productoService.Crear(producto).subscribe(() => {
        console.log('Producto creado');
        this.form.reset({
          productName: '',
          description: '',
          productPrice: 0,
          categoryId: null
        });
        this.productoCreado.emit();
      });
    }
  }
}
