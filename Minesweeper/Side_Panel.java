
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Side_Panel extends JPanel implements ChangeListener{
    int width;
    int height;
    JButton button;
    JButton help;
    JSlider slider;
    JLabel label;
    // add progressbar
    static int numOfBombs = 10;
    Side_Panel(int width, int height){
        this.width = width;
        this.height = height;
        this.setLayout(new BorderLayout(20,20));
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);

        help = new JButton();
        help.setText("help");
        help.setBackground(Color.white);
        help.setFocusable(false);
        help.setBounds(10,50, 180,100);

        button = new JButton();
        button.setText("reset");
        button.setBackground(Color.white);
        button.setFocusable(false);
        button.setBounds(10, 160, 180,100);
        

        label = new JLabel();
        slider = new JSlider(0,100,10);
        slider.setPreferredSize(new Dimension(100,300));    // slider dimensions
        
        slider.setPaintTicks(true);                         //sets ticks but need to set spacing
        slider.setMinorTickSpacing(10);                     //sets small ticks
        slider.setBackground(Color.YELLOW);
        slider.setForeground(Color.orange);
        
        slider.setPaintTrack(true);                        //larger ticks
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);                                 // sets numbers on line
        slider.setFont(new Font("Droid Sans Mono", Font.BOLD,20));

        slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("1/"+ slider.getValue() + " chance bomb");
        label.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

        slider.addChangeListener(this);

        this.add(button, BorderLayout.SOUTH);
        this.add(help, BorderLayout.NORTH);
        
        this.add(label, BorderLayout.NORTH);
        this.add(slider, BorderLayout.SOUTH);
        
    
    }
    public static int GetNumOfBombs(){
        return numOfBombs;
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        numOfBombs = slider.getValue();
        label.setText("1/"+ slider.getValue() + " chance bomb"); // slider needs a change listener to slider
    }
    
    
}
