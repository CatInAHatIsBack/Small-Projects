import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-grid-cell',
  template: `
    <button nbButton status="primary" *ngIf="!value">{{ value }}</button>
    <button nbButton hero status="success" *ngIf="value == 'X'">{{ value }}</button>
    <button nbButton hero status="info" *ngIf="value == 'O'">{{ value }}</button>
  `, 

  styles: [ 'button {width: 100%; height: 100%; font-size: 5em !important; }'],
  // styleUrls: ['./grid-cell.component.scss']
})

export class GridCellComponent implements OnInit {
  
  isEnd: boolean | undefined;
  isStart: boolean | undefined;
  isWall: boolean | undefined;
  isPath: boolean | undefined;
  isCurrent: boolean | undefined;
  isVisitedByLightGray: boolean | undefined;
  isVisitedByDarkGray: boolean | undefined;

  @Input()  value: 'X' | 'O' | undefined; 
  
  i:number | undefined;
  j:number | undefined;
  
  constructor() { 
  }

  ngOnInit(): void {
  }
  makeStart(){
    this.isVisitedByLightGray = true;
    this.isVisitedByDarkGray = true;
    this.isStart = true;
    this.isPath = true;

  }
}


