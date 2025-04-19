import { Component } from '@angular/core';
import { SidenavComponent } from '../../sidenav/sidenav.component';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { IndiceComponent } from '../indice/indice.component';
import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-principal',
  imports: [SidenavComponent,DashboardComponent,IndiceComponent,RouterOutlet],
  templateUrl: './principal.component.html',
  styleUrl: './principal.component.css'
})
export class PrincipalComponent {

}
