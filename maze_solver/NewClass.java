/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author cw
 */

//this class is related to GUI, 2D ARRAY, DESIGNING PURPOSE etc
public class NewClass extends JFrame{
    //i will create 2D array
    int [][] maze=
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},  //here 1's are basicaly represents blocks which are currently blocked.
     {1,0,1,0,1,0,1,0,0,0,0,0,1},   // and 0's are represents block which are not blocked in maze.
     {1,0,1,0,0,0,1,0,1,1,1,0,1},
     {1,0,1,1,1,1,1,0,0,0,0,0,1},
     {1,0,0,0,0,0,0,0,1,1,1,0,1},
     {1,0,1,0,1,1,1,0,1,0,0,0,1},
     {1,0,1,0,1,0,0,0,1,1,1,0,1},
     {1,0,1,0,1,1,1,0,1,0,1,0,1},
     {1,0,0,0,0,0,0,0,0,0,1,9,1},   // 9 is a ending point
     {1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    
    //now i make arraylist for storing path.
    public static List<Integer> path=new ArrayList<>();
    
    //now we have to do GUI
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // now we gonna call our DepthFirst
        DepthFirst.searchpath(maze, 1, 1, path);
        //now i will print that path
        System.out.println(path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(100,50);
        
        // now i need to do decoration, color and i draw the lines on those square or rectangle.
        
        super.paint(g);   // by this we paint our components
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){  //using this two for loops i am accessing all the elements from the 2D array.
                Color color; // i create rectangles and i want to fill the colors in rectangles.
                
                switch(maze[i][j]){   // by this switch stmt i fill the color bsaed on numbers(1,0,9).
                    case 1: color=Color.BLACK;
                            break;
                    case 9: color=Color.RED;
                            break;
                    default: color=Color.WHITE;
                             break;
                }
                g.setColor(color);    // we are set the color
                g.fillRect(30*j,30*i,30,30);   // it is acualy filling the rectangle.i want to make proper rectangle.
                g.setColor(Color.RED);    //it set the rectangle boundry color.
                g.drawRect(30*j,30*i,30,30);   // it is actualy drawing the rectangles.
     
            }
        }
        // now i want to access the path
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            System.out.println("x coordinates"+pathx);
            System.out.println("y coordinates"+pathy); // these println lines for my reference.
            
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx,30*pathy,30,30);
            
        }
            
 
    }
    public static void main(String[] args){
        NewClass view=new NewClass();
        view.setVisible(true);
    }
}
