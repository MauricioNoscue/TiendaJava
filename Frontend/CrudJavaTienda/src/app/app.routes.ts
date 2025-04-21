import { RegisterUserComponent } from './pages/registerPage/register-user/register-user.component';
import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { PrincipalComponent } from './pages/principal/principal.component';
import { IndiceComponent } from './pages/indice/indice.component';
import { CrearComponent } from '../crear/crear.component';
import { EditarComponent } from './editar/editar.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { LoginComponent } from './pages/registerPage/login/login.component';
import { RegisterComponent } from './pages/registerPage/register/register.component';
import { RegisterdosComponent } from './pages/registerPage/componentes/registerdos/registerdos.component';
import { CategoriaComponent } from './pages/CateoriaPage/categoria/categoria.component';
import { ProductoComponent } from './pages/ProductosPage/producto/producto.component';
import { ProveedorComponent } from './pages/proveedoresPage/proveedor/proveedor.component';

export const routes: Routes = [




  {
    path: '',
    component: PrincipalComponent,
    children: [
      { path: '', redirectTo: 'inicio', pathMatch: 'full' },
      { path: 'indice', component: IndiceComponent },
      { path: 'crear', component: CrearComponent },
      { path: 'inicio', component: InicioComponent },
      {path:"actualizar/:id", component:EditarComponent},
      { path: 'categoria', component: CategoriaComponent },
      { path: 'productos', component: ProductoComponent },
      { path: 'proveedores', component: ProveedorComponent },
    ]
  },
  {path:'login', component: LoginComponent},
  {path:'register', component: RegisterComponent},
  {path:'registerUser', component: RegisterUserComponent}



];
