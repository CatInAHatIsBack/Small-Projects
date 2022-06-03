package GameOfLife.game;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import java.util.random.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GamePanel extends JPanel{
    
    int[][] grid;
    int[][] temp;
    int cols;
    int rows;
    int resolution = 20;
    int height = 400;
    int width = 600;


    GamePanel(){
        cols = width / resolution; 
        rows = height / resolution;

        Random random = new Random();
        this.setBackground(Color.white);
        grid = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = random.nextInt(2);
            }
        }
    }

    GamePanel(int[][] grid){
        this.grid = grid;
        cols = width / resolution; 
        rows = height / resolution;
        temp = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                temp[i][j] = grid[i][j];    
            }
        }
        this.setBackground(Color.white);
        updateNewGrid();
        this.grid = temp;
    }

    public void printgrid(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(" " + this.grid[i][j]);
            }
            System.out.println();
        }
    }

    public void updateNewGrid(){              // rules for game of life
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
              int neigh = getNeighbourCount(i, j);      // prints first
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
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);        // smooths rendering
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    g2.setColor(Color.orange);
                }
                else{
                    g2.setColor(Color.darkGray);
                }
                g2.fillRect(j*resolution - 2, i*resolution - 2, resolution - 1, resolution -1);
            }
        }
    }
    
    public int getNeighbourCount(int i, int j){     // prints first
        // My Moores neighborhoood
        int numOfNeighbours = 0;
        for(int y = -1; y < 2; y++){                // checks opposite edge
            for(int x = -1; x < 2; x++){
                int col = (j + x + cols) % cols; 
                int row = (i + y + rows) % rows; 
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
    
    public int[][] getGrid(){
        return this.grid;
    }
}

//int startPosY =     i - 1 < 0            ? i : i - 1; // selects start pos based on edge
//int startPosX =     j - 1 < 0            ? j : j - 1;
//int endPosY   =     i + 1 > rows - 1     ? i : i + 1;
//int endPosX   =     j + 1 > cols - 1     ? j : j + 1;
//for(int y = startPosY; y <= endPosY; y++){            // ++ for each pos in neighborhood
//    for(int x = startPosX; x <= endPosX; x++){
//        int col = (j + x) % cols; 
//        int row = (i + y) % rows; 
//
//        numOfNeighbours += grid[row][col];
//    }
//}