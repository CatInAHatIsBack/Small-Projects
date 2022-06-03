package GameOfLife.display;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.Color;


public class Cell_Button extends JButton implements MouseListener{
    
    private boolean clicked = false;
    private boolean state = false;
    private boolean newState;
    public static int i;
    public static int j;

    public Cell_Button(int i, int j){
        if(state == false){
            this.setBackground(Color.white);
            this.setText( i + " : " + j);
        }
         if(state == true){
            this.setBackground(Color.black);
            this.setText( i + " : " + j);
        }
        this.addMouseListener(this);
    }

    public Cell_Button(boolean state, int i, int j){
        this.state = state;
        if(state == false){
            this.setText( i + " : " + j);
            this.setBackground(Color.white);
            state = false;
            clicked = false;
        }
         if(state == true){
            this.setText( i + " : " + j);
            this.setBackground(Color.black);
            state = true;
            clicked = true;
            
        }
        this.addMouseListener(this);
    }
    public void setState(boolean state){
        this.newState = state;
    }
    public boolean getState(){
        return state;
    }
    public void updateState(){
        this.state = this.newState;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        //if(clicked == false){
        //    this.setBackground(Color.black);
        //    clicked = true;
        //    state = true;
        //}
        //else{
        //    this.setBackground(Color.white);
        //    clicked = false;
        //    state = false;
        //}   
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        if(state == false){
            this.setBackground(Color.lightGray);
            
        }
        else{
            this.setBackground(Color.darkGray);
            
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if(state == false){
            this.setBackground(Color.white);
            
            
        }
        else{
            this.setBackground(Color.black);
            
            
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if(clicked == false){
            this.setBackground(Color.black);
            clicked = true;
            state = true;
        }
        else{
            this.setBackground(Color.white);
            clicked = false;
            state = false;
        } 
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        //if(clicked == false){
        //    this.setBackground(Color.black);
        //    clicked = true;
        //    state = true;
        //}
        //else{
        //    this.setBackground(Color.white);
        //    clicked = false;
        //    state = false;
        //} 
        
    }
}

