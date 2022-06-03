import { Component, OnInit } from '@angular/core';
import { GridCellComponent } from '../grid-cell/grid-cell.component';

@Component({
  selector: 'app-prep-bunny-escape',
  templateUrl: './prep-bunny-escape.component.html',
  styleUrls: ['./prep-bunny-escape.component.scss']
})
export class PrepBunnyEscapeComponent implements OnInit {

  size = 9;
  grid: any[][] = [];
  
  constructor() { }

  ngOnInit(): void {
    this.setup(this.size); 
  }
  
  setup(size: number){
    for (let i = 0; i < size; i++) {
      this.grid[i] = new Array(size).fill(null);
      console.log(this.grid[i]);
    }
  }

}
    
