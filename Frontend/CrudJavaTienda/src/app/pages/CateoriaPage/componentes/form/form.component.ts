import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  @Input() categoria: categoriaSelect | null = null;
  @Output() submitForm = new EventEmitter<categoriaSelect>();

  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      name: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    if (this.categoria) {
      this.form.patchValue(this.categoria);
    }
  }

  onSubmit() {
    if (this.form.valid) {
      const categoria: categoriaSelect = {
        categoryId: this.categoria?.categoryId || 0,
        name: this.form.value.name
      };
      this.submitForm.emit(categoria);
    }
  }
}
