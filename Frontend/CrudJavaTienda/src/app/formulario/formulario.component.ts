import { Component, EventEmitter, inject, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterLink } from '@angular/router';
import { Person, PersonCreation } from '../../person.models';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core'; // <- importante



@Component({
  selector: 'app-formulario',
  imports: [ReactiveFormsModule, MatFormFieldModule,MatInputModule,MatButtonModule,RouterLink,MatNativeDateModule,MatDatepickerModule],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent  implements OnInit{


    private readonly formBuilder = inject(FormBuilder)
    form = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      documentType: [''],
      document: [''],
      dateBorn: [null],
      phoneNumber: [''],
      eps: [''],
      genero: [''],
    })

    @Input({required:true})
    titulo!:string
    @Input()
    modelo?:Person
    @Output()
    posteoFormulario = new EventEmitter<Person>()

    ngOnInit(): void {
      if (this.modelo !== undefined) {
        this.form.patchValue(this.modelo as any)
      }
    }

    guardarCambios(){
      const person = this.form.value as unknown as Person;
      this.posteoFormulario.emit(person)
      console.log(this.form.value)
    }


}
