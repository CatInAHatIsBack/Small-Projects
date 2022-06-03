package GameOfLife.display.game;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw_Frame extends JFrame{

    
    public Draw_Frame(){
        
        this.setBounds(10, 10, 500, 500);
        






    }
}

//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//JFrame frame = new JFrame();
//        frame.setBounds(10, 10, 512, 512);
//        frame. setUndecorated(true);
//
//        JPanel panel = new JPanel(){
//            @Override
//            public void paint(Graphics g) {
//                Graphics2D g2 = (Graphics2D)g.create();
//                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);        // smooths rendering
//                boolean white = true;
//                for(int i = 0; i < 8; i++){
//                    for(int j = 0; j < 8; j++){
//                        if(white){
//                            g2.setColor(Color.white);
//                        }
//                        else{
//                            g2.setColor(Color.black);
//                        }
//                        g2.fillRect(i*64, j*64, 64, 64);
//                        white =! white;
//                    }
//                    white =! white;
//                }
//            }     
//        };
//
//        frame.add(panel);
//        frame.setVisible(true);