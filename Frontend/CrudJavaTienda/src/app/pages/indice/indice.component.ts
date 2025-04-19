import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';

import {MatTableModule} from '@angular/material/table';
import { PersonServiceService } from '../../../person-service.service';
import { Person } from '../../../person.models';

@Component({
  selector: 'app-indice',
  imports:[MatButtonModule, RouterLink,MatTableModule],
  templateUrl: './indice.component.html',
  styleUrl: './indice.component.css'
})
export class IndiceComponent {
 PersonServiceService= inject(PersonServiceService);
 Persons?:Person[];
 columnasMostrar = [

  'firstName',
  'lastName',
  'documentType',
  'document',
  'dateBorn',
  'phoneNumber',
  'eps',
  'genero',
  'acciones'
];
constructor(){
  this.cargarProductos()
}

cargarProductos(){
  this.PersonServiceService.TraerTodo().subscribe(Persons =>{
    this.Persons = Persons
  })
}

borrar(id:number){
  this.PersonServiceService.eliminar(id).subscribe(()=>{
    this.cargarProductos();
  })
}


}
