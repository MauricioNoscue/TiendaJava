import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { PersonServiceService } from '../person-service.service';
import { PersonCreation } from '../person.models';
import { FormularioComponent } from '../app/formulario/formulario.component';

@Component({
  selector: 'app-crear',
  imports: [FormularioComponent],
  templateUrl: './crear.component.html',
  styleUrl: './crear.component.css'
})
export class CrearComponent {
  router = inject(Router);
  PersonServiceService = inject(PersonServiceService);

  guardarCambios(person :PersonCreation){
    this.PersonServiceService.Crear(person).subscribe(()=>{
      this.router.navigate(['indice']);
    })

  }
}
