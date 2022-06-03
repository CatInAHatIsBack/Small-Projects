package GameOfLife.display;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Itteration_Slider extends JPanel implements ChangeListener{

    static JLabel label;
    static JSlider slider;
    
    private static int numOfItterations = 10;

    Itteration_Slider(){
        this.setLayout(new BorderLayout(20,20));
        //this.setBackground(Color.blue);
        
        label = new JLabel();
        slider = new JSlider(0,100,10);    //  JSlider(starting val, end val, starting point on initiation) //adjusting start or end val 
                                            // will change labels  =v // horizontal by default
        slider.setPreferredSize(new Dimension(50,200));    // slider dimensions

        slider.setPaintTicks(true);                         //sets ticks but need to set spacing
        slider.setMinorTickSpacing(10);                     //sets small ticks
        slider.setBackground(Color.YELLOW);
        slider.setForeground(Color.orange);
        
        slider.setPaintTrack(true);                        //larger ticks
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);                                 // sets numbers on line
        slider.setFont(new Font("Droid Sans Mono", Font.BOLD,20));

        slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("# of times = "+ slider.getValue());
        label.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));
        //label.set
        
        slider.addChangeListener(this);
        this.add(label, BorderLayout.NORTH);
        this.add(slider, BorderLayout.SOUTH);
    }
    public static int GetNumOfItterations(){
        return numOfItterations;
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        numOfItterations = slider.getValue();
        label.setText("# of times = "+ slider.getValue()); // slider needs a change listener to slider
        
    }
    
}   