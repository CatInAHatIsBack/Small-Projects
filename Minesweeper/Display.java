import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.*;
public class Display extends JFrame implements ActionListener{
    
    Side_Panel panel;
    Game_Canvas game_Canvas;
    int width = 1000;
    int height = 600;
    public Display(){
        panel = new Side_Panel(2 * width / 10, height);
        panel.button.addActionListener(this);
        panel.help.addActionListener(this);
        game_Canvas = new Game_Canvas(8 * width / 10, height);
        this.add(panel, BorderLayout.WEST);
        this.add(game_Canvas, BorderLayout.EAST);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panel.button){
            this.remove(game_Canvas);
            game_Canvas = new Game_Canvas(8 * width / 10, height, panel.slider.getValue());
            this.add(game_Canvas);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource() == panel.help){
            game_Canvas.help();
        }
    } 
    
    
}
