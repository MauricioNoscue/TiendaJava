import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { PersonCreated } from '../../../../../Models/person.models';
import { PersonService } from '../../../../../service/person.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-formulario-register',
  imports: [RouterModule,FormsModule],
  templateUrl: './formulario-register.component.html',
  styleUrl: './formulario-register.component.css'
})
export class FormularioRegisterComponent {
  person: PersonCreated = {
    personName: '',
    lastName: '',
    email: '',
    phone: ''
  };

  constructor(private personService: PersonService, private router: Router){}

  onSubmit() {
    this.personService.Login(this.person).subscribe(
      (response) => {
        console.log('Persona registrada:', response);
        // Aquí puedes redirigir o mostrar un mensaje de éxito
        this.router.navigate(['/registerUser']);
      },
      (error) => {
        console.error('Error al registrar la persona:', error);
        // Aquí puedes mostrar un mensaje de error
      }
    );
  }
}
