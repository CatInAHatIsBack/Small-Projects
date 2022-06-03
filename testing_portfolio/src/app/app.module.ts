import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { TicTacToeComponent } from './tic-tac-toe/tic-tac-toe.component';
import { SquareComponent } from './square/square.component';
import { NbThemeModule, NbLayoutModule, NbMenuModule, NbCardModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { NbButtonModule } from '@nebular/theme';
import { GoogleFoobarComponent } from './google-foobar/google-foobar.component';
import { DoomsdayFuelComponent } from './doomsday-fuel/doomsday-fuel.component';
import { PrepBunnyEscapeComponent } from './prep-bunny-escape/prep-bunny-escape.component';
import { GridCellComponent } from './grid-cell/grid-cell.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TicTacToeComponent,
    SquareComponent,
    GoogleFoobarComponent,
    DoomsdayFuelComponent,
    PrepBunnyEscapeComponent,
    GridCellComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatButtonModule,
    NbThemeModule.forRoot({ name: 'cosmic' }),
    NbLayoutModule,
    NbEvaIconsModule,
    NbButtonModule,
    NbMenuModule.forRoot(),
    NbCardModule,
  ],
  exports:[
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
