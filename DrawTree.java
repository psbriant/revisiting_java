/**
* Description: This program draws a fractal inspired tree using the java graphics library.
**/

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Canvas;

public class DrawTree extends Canvas {
      
    /**
    * Constructs branches of the tree.  
    * 
    * @param g The graphics library.
    * @param locX The value representing the starting point of the branches on the x-axis.
    * @param locY The value representing the starting point of the branches on the y-axis.
    * @param size The distance between the start coordinates and the end coordinates of each branch.
    * @param shift Offsets branches to make the distance between them less linear.
    * @param level The number of tiers of branches in the tree.
    * 
    * @return None
    *
    **/
    private void drawBranches(Graphics g, double locX, double locY, double size, double shift, int level) {
    
        int startLocX = (int)locX;
        int startLocY = (int)locY;
        
        double endLocXb1 = locX - size - shift;
        double endLocYb1 = locY - size + shift;
        double endLocXb2 = locX + size + shift;
        double endLocYb2 = locY - size + shift;
        
        int endLocXb1Int = (int)endLocXb1;
        int endLocYb1Int = (int)endLocYb1;
        int endLocXb2Int = (int)endLocXb2;
        int endLocYb2Int = (int)endLocYb2;
        
        g.drawLine(startLocX, startLocY, endLocXb1Int, endLocYb1Int);
        g.drawLine(startLocX, startLocY, endLocXb2Int, endLocYb2Int);
          
        if (level > 1) {
            
            // Use recursion to draw the next set of branches
            drawBranches(g, endLocXb1, endLocYb1, size * 0.7, (size * 0.7) / 2, level - 1);
            drawBranches(g, endLocXb2, endLocYb2, size * 0.7, (size * 0.7) / 2, level - 1);

        } else {
            
            // Create groups of leafs for the end branches
            g.drawOval(endLocXb1Int - 3, endLocYb1Int - 5, 5, 4);
            g.fillOval(endLocXb1Int - 3, endLocYb1Int - 5, 5, 4);
            g.drawOval(endLocXb2Int - 3, endLocYb2Int - 5, 5, 4);
            g.fillOval(endLocXb2Int - 3, endLocYb2Int - 5, 5, 4);
        }        
    }
    
    /**
    * Method for building the trunk and branches of the tree.
    * 
    * @param g The graphics library. 
    *
    * @return None
    *
    **/
    public void paint(Graphics g) {
        
        // Draw the branches
        drawBranches(g, 500.0, 450.0, 30.0, 15.0, 5);
        
        // Draw the trunk after the branches
        g.drawLine(500, 450, 500, 600);          
    }
    
    public static void main(String[] args) {
    
        // Initialize and draw the full tree.
        DrawTree d = new DrawTree();
        JFrame f = new JFrame();
        f.add(d);
        f.setSize(1000, 1000);
        f.setVisible(true);       
    
  }

}



