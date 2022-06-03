package GameOfLife.game;
public class ConwaysGame {
   static boolean expand = false;
    static int itterations = 3;
    static int x;
    static int y;
    
    public static int[][] ConwaysGame(int[][] startgrid, int itterations){
        
        // asign x & y
        x = findXArr(startgrid);
        y = findYArr(startgrid);
        // expand grid by 2x & 2y
        int[][] grid = expandGridByTwo(startgrid);
        
        while(itterations > 0){
            if(checkrAround(grid) == true){
                grid = expandGridByTwo(grid);
            }
            grid = updateNewGrid(grid);
            itterations--;
        }
        grid = gridCrop(grid); 
        return grid; 
    }  

    //vvvvvvvvvvvvvvvvvvvv== just grid crop after fin ==vvvvvvvvvvvvv
    public static int[][] gridCrop(int[][] grid){
        while(checkTopLine(grid) == false){
            y--;
            grid = cropTopLine(grid, x, y);
        }
        while(checkBottomLine(grid) == false){
            y--;
            grid = cropBottomLine(grid, x, y);
        }
        while(checkLeftLine(grid) == false){
            x--;
            grid = cropLeftLine(grid, x, y);
        }
        while(checkRightLine(grid) == false){
            x--;
            grid = cropRightLine(grid, x, y);
        }
        
        return grid;
    }
    private static int[][] cropTopLine(int[][] grid, int x, int y){

        int[][] temp = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                temp[i][j] = grid[i+1][j];
            }
        }
        return temp;
    }
    private static int[][] cropBottomLine(int[][] grid, int x, int y){
        
        int[][] temp = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }
    private static int[][] cropRightLine(int[][] grid, int x, int y){

        int[][] temp = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }
    private static int[][] cropLeftLine(int[][] grid, int x, int y){

        int[][] temp = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                temp[i][j] = grid[i][j + 1];
            }
        }
        return temp;
    }
    
    private static boolean checkBottomLine(int[][] grid) {
        boolean check = false;
        for(int i = 0; i < x; i++){   // check bottom line
            if(grid[y - 1][i] == 1){
                check = true;
            }
        }
        return check;
    }
    private static boolean checkLeftLine(int[][] grid) {
        boolean check = false;
        for(int i = 0; i < y ; i++){   // check left line
            if(grid[i][0] == 1){
                check = true;
            }
        }
        return check;
    }
    private static boolean checkRightLine(int[][] grid) {
        boolean check = false;
        for(int i = 0; i < y ; i++){   // check right line
            if(grid[i][x - 1] == 1){
                check = true;
            }
        }
        return check;
    }
    private static boolean checkTopLine(int[][] grid) {
        boolean check = false;
        for(int i = 0; i < x ; i++){   // check top line
            if(grid[0][i] == 1){
                check = true;
            }
        }
        return check;
    }
    //^^^^^^^^^^^^^^^== cropping after itter is fin ==^^^^^^^^^


    //vvvvvvvvvvvvvvv== game logic and basic stuff ==vvvvvvvvvv
    public static int[][] updateNewGrid(int[][] grid){
    //
        
    // initiate temp grid
        int[][] temp = new int[y][x];  
    // copy grid to temp
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                temp[i][j] = grid[i][j];
            }
        }
    // rules for game of life
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
              int neigh = getNeighbourCount(i, j, grid);      // prints first
              if(neigh < 2){                            
                if(grid[i][j] == 1){
                    temp[i][j] -= 1 ;
                }
              }
              if(neigh > 3){
                  if(grid[i][j] == 1){
                      temp[i][j] -= 1;
                  }
              }
              if(neigh == 2 || neigh == 3){
                  if(grid[i][j] == 1){
                      temp[i][j] = 1;
                  }
              }
              if(grid[i][j] == 0 && neigh == 3){
                temp[i][j] += 1;

              }
            }
        }
        return temp;
    }
    public static int getNeighbourCount(int i, int j, int[][] grid){     // prints first
        // My Moores neighborhoood
        int numOfNeighbours = 0;
        for(int v = -1; v < 2; v++){                // checks opposite edge
            for(int h = -1; h < 2; h++){
                int col = (j + h + x) % x; 
                int row = (i + v + y) % y; 
                numOfNeighbours += grid[row][col];
            }
        }
        if(grid[i][j] == 1){
            return numOfNeighbours - 1;
        }
        else{
            return numOfNeighbours;
        }
    }
    public static boolean checkrAround(int[][] grid){
        boolean check = false;
        for(int i = 0; i < x; i++){
            if(grid[0][i] == 1){    // top line
                check = true;
            }
        }
        for(int i = 0; i < x; i++){ // bottom line
            if(grid[y - 1][i] == 1){
                check = true;
            }
        }
        for(int i = 0; i < y; i++){ // right line
            if(grid[i][x - 1] == 1){
                check = true;
            }
        }
        for(int i = 0; i < y; i++){ // left line
            if(grid[i][0] == 1){
                check = true;
            }
        }
        return check;
    }    
    public static int[][] expandGridByTwo(int[][] grid){
        x += 2;
        y += 2;
        int[][] temp = new int[y][x];
        for(int i = 1; i < y - 1; i++){
            for(int j = 1; j < x - 1; j++){
                temp[i][j] = grid[i - 1][j - 1];
            }
        }
        return temp;
    }
    public static int findXArr(int[][] grid){
        int width = grid[0].length;
        return width;
    }
     public static int findYArr(int[][] grid){
        int height = grid.length;
        return height;
    }
    public static void printgrid(int[][] grid){
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
            
        }
    }
    // Made by CatInAHatIsBack 
}
