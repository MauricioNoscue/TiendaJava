import { Component } from '@angular/core';
import { SelectorRolComponent } from '../selector-rol/selector-rol.component';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-dashboard',
  imports: [SelectorRolComponent,CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  userData: any = null;
  
  constructor(private authService: AuthService) {}

  ngOnInit() {
    // Asigna los datos obtenidos a la variable userData
    this.userData = this.authService.getCurrentUser();
    console.log("user", this.userData);
  }
}
