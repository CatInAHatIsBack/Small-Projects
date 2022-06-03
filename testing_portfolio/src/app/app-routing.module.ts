import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoomsdayFuelComponent } from './doomsday-fuel/doomsday-fuel.component';
import { GoogleFoobarComponent } from './google-foobar/google-foobar.component';
import { HomeComponent } from './home/home.component';
import { PrepBunnyEscapeComponent } from './prep-bunny-escape/prep-bunny-escape.component';
import { TicTacToeComponent } from './tic-tac-toe/tic-tac-toe.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'tic-tac-toe', component: TicTacToeComponent },
  { path: 'google-foobar', component: GoogleFoobarComponent },
  { path: 'doomsday-fuel', component: DoomsdayFuelComponent },
  { path: 'prep-bunny-escape', component: PrepBunnyEscapeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
