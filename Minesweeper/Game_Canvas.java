import java.awt.*;
import java.awt.Graphics;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.*;

public class Game_Canvas extends JPanel implements MouseListener{
    
    int width;
    int height;

    
    int rows;
    int cols;
    Cell[][] grid;
    int resolution = 50;
    int probability;
    Image bomb;
    Image bomb_flag;

    Random random;
    Game_Canvas(int width, int height){
        this.probability = Side_Panel.numOfBombs;
        //this.probability = Side_Panel.GetNumOfBombs();
        random = new Random();
        
        this.width = width;
        this.height = height;
        rows = height / resolution;
        cols = width / resolution;
        this.grid = new Cell[rows][cols];
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = new Cell();
            }
        }
        bomb = new ImageIcon("png/bomb_png.png").getImage();
        Image temp = bomb.getScaledInstance(resolution, resolution, java.awt.Image.SCALE_SMOOTH);
        bomb = new ImageIcon(temp).getImage();

        bomb_flag = new ImageIcon("png/bomb_flag.jpg").getImage();
        temp = bomb_flag.getScaledInstance(resolution, resolution, java.awt.Image.SCALE_SMOOTH);
        bomb_flag = new ImageIcon(temp).getImage();


        init();
        
    }
    Game_Canvas(int width, int height, int probability){
        this.probability = probability;
        //this.probability = Side_Panel.GetNumOfBombs();
        random = new Random();
        
        this.width = width;
        this.height = height;
        rows = height / resolution;
        cols = width / resolution;
        this.grid = new Cell[rows][cols];
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = new Cell();
            }
        }
        bomb = new ImageIcon("png/bomb_png.png").getImage();
        Image temp = bomb.getScaledInstance(resolution, resolution, java.awt.Image.SCALE_SMOOTH);
        bomb = new ImageIcon(temp).getImage();

        bomb_flag = new ImageIcon("png/bomb_flag.jpg").getImage();
        temp = bomb_flag.getScaledInstance(resolution, resolution, java.awt.Image.SCALE_SMOOTH);
        bomb_flag = new ImageIcon(temp).getImage();


        init();
        
    }

        // for(int i = 0; i < rows; i++){
        //     for(int j = 0; j < cols; j++){
        //         grid[i][j];
        //     }
        // }
    public void init(){
        // initialises a cell grid and randomises bombs based on probability
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j].makeCell(random.nextInt(probability));
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!grid[i][j].isBomb){
                    // grid[i][j].setLabelText(String.valueOf(getNeighbourCount(i, j)));
                    grid[i][j].neighbors = getNeighbourCount(i, j);

                }
            }
        }
        
    }
    public int getNeighbourCount(int i, int j){     // prints first
                                                    // My Moores neighborhoood
        int numOfNeighbours = 0;
        
        int startPosY =     i - 1 < 0            ? i : i - 1;
        int startPosX =     j - 1 < 0            ? j : j - 1;
        int endPosY   =     i + 1 > this.rows - 1  ? i : i + 1;
        int endPosX   =     j + 1 > this.cols - 1  ? j : j + 1;

        for(int y = startPosY; y <= endPosY; y++){
            for(int x = startPosX; x <= endPosX; x++){
            if(this.grid[y][x].isBomb == true){
              numOfNeighbours++;
              System.out.println(x + " , " + y + " : " + grid[y][x].isBomb);
            }
            else{
                System.out.println(x + " , " + y + " : " + grid[y][x].isBomb);
            }
          }
        }
        return numOfNeighbours;
    }
    @Override
    protected void paintComponent(Graphics g){
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setColor(Color.orange);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j].isClicked == true){
                    paintOnClick(g2, i, j);
                }
                else{
                    g2.setColor(Color.green);
                    g2.fillRect(resolution * j, resolution * i, resolution-1, resolution-1);
                }
                if(grid[i][j].isFlag == true){
                    g2.drawImage(bomb_flag, resolution * j, resolution * i, null);
                }
            }
        }    
    }
    public void paintOnClick(Graphics g2, int i , int j){
        g2.setColor(Color.white);
        g2.fillRect(resolution * j, resolution * i, resolution-1, resolution-1);
            if(!grid[i][j].isBomb){
                g2.setColor(Color.red);
                g2.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
                g2.drawString(String.valueOf(grid[i][j].neighbors), resolution * j + 15, resolution * i + 35);
            }
            else if(grid[i][j].isBomb == true){
                g2.drawImage(bomb, resolution * j, resolution * i,null);    
            }
            //else{
            //    g2.setColor(Color.blue);
            //    g2.fillRect(resolution * j, resolution * i, resolution-1, resolution-1);
            //}
    }
    public int getRow(Point p){
        return ((int)(p.getY()/resolution));
    }
    public int getColumn(Point p){
        return ((int)(p.getX()/resolution));
    }

    public void MakeFlag(Point p){
        int column = getColumn(p);
        int row = getRow(p);
        System.out.println(" row : " + row + " column : " + column);
        grid[row][column].makeFlag();
        
    }

    public void openCell(Point p){
        int column = getColumn(p);
        int row = getRow(p);
        System.out.println(" row : " + row + " column : " + column);
        grid[row][column].openCell();
        if(grid[row][column].isBomb){
            repaint();
            //while(true){
                JOptionPane.showMessageDialog(null, "You Lose!!", "title", JOptionPane.WARNING_MESSAGE);
            //}
        }
       
    }

    public void help(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j].neighbors == 0 && !grid[i][j].isBomb){
                    grid[i][j].openCell();
                }
            }
        }
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
        

        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Point p = new Point(e.getPoint());
        if(SwingUtilities.isRightMouseButton(e)){
            MakeFlag(p);
            repaint();
        }
        else if (SwingUtilities.isLeftMouseButton(e)){
            openCell(p);
            repaint();
        }
        
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
