package GameOfLife.display;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Nav_Panel extends JPanel{

    static Itteration_Slider slider;

    Nav_Panel(){

        slider = new Itteration_Slider();
        

        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(200, 600));
        
        this.add(slider);

    }
    
}
