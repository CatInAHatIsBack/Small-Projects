# Minesweeper
Testing out JPanel and drawing components through classes.

The code you will find for now is uncommented and unfixed.
    It is a note program of sorts, the earliest implementation with all classes and functions just thown thrown in all willy nilly. The basic functionality is there, the basic structure is :
                
                - Cell class 
                    - Is bomb?
                    - Is flag?
                    - Is clicked?
                    - How many neighbors
                - Game_Canvas
                    - Jframe 
                        - JPanel(side panel)
                        - JPanel(Game_Canvas)
                - Left Panel (Side_Panel)
                    - Refresh button
                    - Help button
                        - starts you off with some easy cells
                    -  Slider 
                - Right Pabel(Game_Canvas)
                    - Main Game Display
                    - Contains most classes for the game to function properly


    - Basic funtionallity :
        - Right Click = Make Flag
        - Left Click = open cell
            - Check if bomb and displays popup if true
                - Commented out while loop - makes the pop up window open when closed :{P
        - Itteration slider to set probability of any given cell being bomb
        - Game can still continue after you hit a bomb for experimental purpose