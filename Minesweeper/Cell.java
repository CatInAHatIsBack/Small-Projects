import javax.swing.JLabel;
import java.awt.Color;


public class Cell extends JLabel{

    boolean isBomb;
    boolean isClicked; 
    int neighbors;
    boolean isFlag;
    
    
    
    Cell(){
        this.isClicked = false;
        this.isBomb = false;
        this.isFlag = false;
    }
    public void makeCell(int probability){
        if(probability == 1){
            this.isBomb = true;
        }
        
    } 
    public void makeFlag(){
        if(this.isFlag == true){
            this.isFlag = false;
        }
        else{
            this.isFlag = true;
        }
    }
    public int openCell(){
        if(isBomb == true){
            // display bomb
        }
        // display neighbours;
        this.isClicked = true;
        return neighbors;
    }
    
}
