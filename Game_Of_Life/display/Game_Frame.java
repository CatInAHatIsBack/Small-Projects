package GameOfLife.display;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.*;

public class Game_Frame extends JFrame implements ActionListener{
    
    JButton updateButton;
    JButton nextButton;
    JButton prevButton;

    JButton navPanelColor;
    JButton buttonColor;

    JButton sliderColorB;
    JButton sliderColorF;

    JButton mainPanelColor;
    

    Game_Panel game_Panel;
    Nav_Panel nav_Panel;


    
    private static Cell_Button[][] grid;
    private int xy;
    public boolean running;
    

    public Game_Frame(){
        
        updateButton = new JButton();
        updateButton.setText("Update grid");
        updateButton.setSize(60,20);
        updateButton.addActionListener(this);


        nextButton = new JButton();
        nextButton.setText("Next");
        nextButton.setSize(60,20);
        nextButton.addActionListener(this);

        prevButton = new JButton();
        prevButton.setText("Prev");
        prevButton.setSize(60,20);
        prevButton.addActionListener(this);


        navPanelColor = new JButton();
        navPanelColor.setText("nav Panel color");
        navPanelColor.setSize(60,20);
        navPanelColor.addActionListener(this);

        sliderColorB = new JButton();
        sliderColorB.setText("slider B");
        sliderColorB.setSize(60,20);
        sliderColorB.addActionListener(this);

        sliderColorF = new JButton();
        sliderColorF.setText("slider F");
        sliderColorF.setSize(60,20);
        sliderColorF.addActionListener(this);

        buttonColor = new JButton();
        buttonColor.setText("button Color");
        buttonColor.setSize(60,20);
        buttonColor.addActionListener(this);
        
        mainPanelColor = new JButton();
        mainPanelColor.setText("Main panel");
        mainPanelColor.setSize(60,20);
        mainPanelColor.addActionListener(this);



        game_Panel = new Game_Panel();

        nav_Panel = new Nav_Panel();
        

       
        nav_Panel.add(updateButton);
        nav_Panel.add(nextButton);
        nav_Panel.add(prevButton);

        nav_Panel.add(navPanelColor);
        nav_Panel.add(sliderColorB);
        nav_Panel.add(sliderColorF);

        nav_Panel.add(buttonColor);
        nav_Panel.add(mainPanelColor);

        

        

        this.add(nav_Panel, BorderLayout.WEST);
        this.add(game_Panel, BorderLayout.EAST);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);        
    }
    



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateButton){
            this.remove(game_Panel);
            game_Panel = new Game_Panel();
            this.add(game_Panel);
            SwingUtilities.updateComponentTreeUI(this);
        } 
        if(e.getSource() == nextButton){
            Cell_Button[][] getGrid = Game_Panel.getGrid();
            
                //for(int i = 0; i < 10; i++){
                //    for(int j = 0; j < 10; j++)
                //    
                //    System.out.println(getGrid[i][j].getState());
                //}

                this.remove(game_Panel);
                game_Panel = new Game_Panel(getGrid);
                this.add(game_Panel);
                SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource() == prevButton){
            
        }
        if(e.getSource() == navPanelColor){
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null,"pick a color", Color.black); // stores selected color in color variable
            
            nav_Panel.setBackground(color);
        }
        if(e.getSource() == sliderColorB){
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null,"pick a color", Color.black); // stores selected color in color variable
            
            Nav_Panel.slider.setBackground(color);
            Itteration_Slider.slider.setBackground(color);
        }
        if(e.getSource() == sliderColorF){
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null,"pick a color", Color.black); // stores selected color in color variable
            
            Itteration_Slider.label.setForeground(color);
            Itteration_Slider.slider.setForeground(color);
        }
        if(e.getSource() == buttonColor){
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null,"pick a color", Color.black); // stores selected color in color variable
            
            updateButton.setBackground(color);
            nextButton.setBackground(color);
            prevButton.setBackground(color);
        }
        if(e.getSource() == mainPanelColor){
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null,"pick a color", Color.black); // stores selected color in color variable
            
            game_Panel.setBackground(color);
        }
    }
    // navPanelColor;
    // sliderColor;
    // buttonColor;
    // mainPanelColor;
    // cellColorOff;
    // cellColorOn;


}

//public void setUpButtonListeners(){
//        ActionListener buttonListener = new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                System.out.println("click");
//            }
//        };
//        nextButton.addActionListener(buttonListener);
//    }