package GameOfLife.display;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.*;



public class Game_Panel extends JPanel{
   
    private static Cell_Button[][] grid;
    private int xy;
    public boolean running;
    
    
    Game_Panel(){
        this.xy = Itteration_Slider.GetNumOfItterations();
        
        this.grid = new Cell_Button[xy][xy];
        
        this.setBackground(Color.orange);
        this.setPreferredSize(new Dimension(600, 600));
        this.setLayout(new GridLayout(xy, xy, 2, 2));
        
        for(int i = 0; i < this.xy; i++){
          for(int j = 0; j < this.xy; j++){
            grid[i][j] = new Cell_Button(i, j);
            this.add(grid[i][j]);
          }
        } 
    }
    Game_Panel(Cell_Button[][] grid){
        this.grid = grid;
        this.xy = Itteration_Slider.GetNumOfItterations();

        this.updateNewGrid();
        this.setBackground(Color.orange);
        this.setPreferredSize(new Dimension(600, 600));
        this.setLayout(new GridLayout(xy, xy, 2, 2));
        
        for(int i = 0; i < this.xy; i++){
            for(int j = 0; j < this.xy; j++){
              this.grid[i][j] = new Cell_Button(grid[i][j].getState(),i,j);
              this.add(grid[i][j]);
              System.out.println(grid[i][j].getState() + " : " + i +", "+ j);
            }
        }
        
    }
    

    public static Cell_Button[][] getGrid(){
        return grid;
    }

    



    public void updateNewGrid(){              // rules for game of life
        for(int i = 0; i < this.xy; i++){
            for(int j = 0; j < this.xy; j++){
              int neigh = getNeighbourCount(i, j);      // prints first
              
              System.out.println();                                 // prints second
              System.out.println(neigh + "  neighbours");           // prints second
              System.out.println("================");               // prints second
              System.out.println();                                 // prints second

              if(neigh < 2){                            
                if(grid[i][j].getState() == true){
                    grid[i][j].setState(false);
                      System.out.println("================");
                      System.out.println(i + ", " + j + " : " + grid[i][j].getState() + " : Cell dies from underpopulation");
                      System.out.println("================");   
                      System.out.println(); 

                }
              }
              if(neigh > 3){
                  if(grid[i][j].getState() == true){
                      grid[i][j].setState(false);
                      System.out.println("================");
                      System.out.println(i + ", " + j + " : " + grid[i][j].getState() + " : Cell dies from overpopulation");
                      System.out.println("================");   
                      System.out.println(); 
                  }
              }
              if(neigh == 2 || neigh == 3){
                  if(grid[i][j].getState() == true){
                      grid[i][j].setState(true);
                      System.out.println("================");
                      System.out.println(i + ", " + j + " : " + grid[i][j].getState() + " Cell survives ");
                      System.out.println("================");   
                      System.out.println(); 
                  }
              }
              if(grid[i][j].getState() == false && neigh == 3){
                grid[i][j].setState(true);
                System.out.println("================");
                System.out.println(i + ", " + j + " : " + grid[i][j].getState() + " changed to true");
                System.out.println("================");   
                System.out.println(); 
              }
            }
        }
        
        for(int i = 0; i < this.xy; i++){
            int neigh = 0;
            for(int j = 0 ; j < this.xy; j++){
                neigh = getNeighbourCount(i, j);
                grid[i][j].updateState();
              System.out.println("*****************");
              System.out.println("*****************");
              System.out.println("================");
              System.out.println();
              System.out.println(i + ", " + j + " : " + grid[i][j].getState() + " : cell state");
              System.out.println();
              System.out.println("*****************");
              System.out.println("*****************");
            }

              System.out.println();
              System.out.println( "line "+ i +" over");
              System.out.println("================");
              System.out.println();
        }
    }


    public int getNeighbourCount(int i, int j){     // prints first
                                                    // My Moores neighborhoood
        int numOfNeighbours = 0;
        
        int startPosX =     i - 1 < 0            ? i : i - 1;
        int startPosY =     j - 1 < 0            ? j : j - 1;
        int endPosX   =     i + 1 > this.xy - 1  ? i : i + 1;
        int endPosY   =     j + 1 > this.xy - 1  ? j : j + 1;

        for(int x = startPosX; x <= endPosX; x++){
            for(int y = startPosY; y <= endPosY; y++){
            if(this.grid[x][y].getState() == true){
              numOfNeighbours++;
              System.out.println(x + " , " + y + " : " + grid[x][y].getState());
            
            }
            else{
                System.out.println(x + " , " + y + " : " + grid[x][y].getState());
            }
          }
        }
        if(grid[i][j].getState() == true){
            return numOfNeighbours - 1;
        }
        else{
            return numOfNeighbours;
        }
    }
}