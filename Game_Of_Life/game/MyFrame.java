package GameOfLife.game;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.event.*;

public class MyFrame extends JFrame implements MouseListener{

    static GamePanel panel;

    int width = 600;
    int height = 400;

    public MyFrame(){
        this.setBounds(10, 10, width, height);
        this.setUndecorated(true);
        //this.setLocationRelativeTo(null);
        
        panel = new GamePanel();
        panel.addMouseListener(this);

        this.add(panel);
        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        int[][] grid = panel.getGrid();
        this.remove(panel);
        panel = new GamePanel(grid);
        panel.addMouseListener(this);
        this.add(panel);
        SwingUtilities.updateComponentTreeUI(this);
        
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
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
