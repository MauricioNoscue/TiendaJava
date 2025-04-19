import { Component, inject, Input, numberAttribute, OnInit } from '@angular/core';
import { PersonServiceService } from '../../person-service.service';
import { Person, PersonCreation } from '../../person.models';
import { ActivatedRoute, Router } from '@angular/router';
import { FormularioComponent } from '../formulario/formulario.component';

@Component({
  selector: 'app-editar',
  imports: [FormularioComponent],
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.css'
})
export class EditarComponent  implements OnInit{
  @Input({transform: numberAttribute})
  id!:number

  PersonServiceService = inject(PersonServiceService);
  router = inject(Router)
  modelo?:Person;
  constructor(
    private route: ActivatedRoute, // 👈 este te da acceso a snapshot

  ) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if (this.id) {
      this.PersonServiceService.obtenerPorId(this.id).subscribe(person => {
        this.modelo = person;
      });
    }
  }

  guardarCambios(person: Person) {
    if (this.modelo) {
      person.id = this.modelo.id; // <--- Asegurate que el ID esté presente
      person.relatedPerson = this.modelo.relatedPerson; // si lo pide tu backend
      person.isDeleted = this.modelo.isDeleted;         // idem
    }

    this.PersonServiceService.actualizarIdNombre(person).subscribe(() => {
      this.router.navigate(['']);
    });
  }

}
