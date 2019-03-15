import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MakerComponent } from './components/maker/maker.component';
import { CheckerComponent } from './components/checker/checker.component';
import {CheckerSearchComponent} from './components/checker/checker-search/checker-search.component';
import { LoginComponent } from './components/login/login.component';
import {MakerCreateComponent} from './components/maker/maker-create/maker-create.component';
import {MakerViewComponent} from './components/maker/maker-view/maker-view.component';
import {CheckerActionsComponent} from './components/checker/checker-actions/checker-actions.component';

const routes: Routes = [
  {path: 'login' , component: LoginComponent },
  { path: 'maker', component: MakerComponent },
  { path: 'checker', component: CheckerComponent },
  { path: 'maker/create', component: MakerCreateComponent},
  {path: 'checker/search' , component:CheckerSearchComponent},
  {path: 'viewCustomer/:id' , component:MakerViewComponent},
  {path: 'actions/:id', component: CheckerActionsComponent},
  {path: '' , component: LoginComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
