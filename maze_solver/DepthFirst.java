/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.List;

/**
 *
 * @author cw
 */
public class DepthFirst {
    // now i will create boolean function, it basically tell us whether the path coming to us is it good to go or not.
    public static boolean searchpath(int [][]maze,int x,int y,List<Integer> path){     // arrlst is need to store path
        if(maze[y][x]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x]==0){ // here i will perform left,right,backward,upward and also check for any block
            maze[y][x]=2;
            
            //now i have to check for possibilities.
            int dx=-1;
            int dy=0;     // these two lines consider for upward direction.
            if(searchpath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx=1;
            dy=0;  // these two lines consider for downward direction.
            if(searchpath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx=0;
            dy=-1;  // these lines consider for, (if i move x in) left direction
            if(searchpath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx=0;
            dy=1; // these lines for right direction.
            if(searchpath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            //yes above i traversing,using that traversal i going left and right,downward and upward direction. by this i reach my final destination.
        }
        
        return false;    // this cndtion for  maze[y][x]==1,here simply return false.
        
    }
    
    
}
