import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * CSC 142:  Program #3
 * 
 * A program in Java code to interact with users, offering the user their
 * selection of five graphic displays.  The program includes one graphic display 
 * given with the assignement and four new displays, increasing in level of 
 * complexity.  A brief description of the graphic displays is provided here:
 * 
 * 1.  Random Confetti.  This is the sample code that was provided for this 
 * exercise.  The program fills a 500x500 pixel screen with 20 pixel square 
 * images each with a randomly assigned color.  Method: RandomConfetti().
 * 
 * 2. Connected Rectangles.  This is the first of the student's offering, which
 * connects several rectangles in cascading fashion and then draws a line to 
 * connect the visible corners of the rectangles. Method: ConnectedRectangles().
 * 
 * 3. Cascading Circles. A method which is built similar to it predecessor, this 
 * method offers cascading circles progressively falling to the lower left hand 
 * corner of the screen. Method: CascadingCircles().
 * 
 * 4. Technicolor Tunnel.  This method uses the Math.sin() method to display a 
 * series of oscillating circles on the screen.  The circles start at only 7px
 * and increase in size gradually to 150px for the last circle, giving the image
 * a 3D appearance.  Method: Technicolor Tunnel().
 * 
 * 5. Rainbow Explosion.  This, the grand finale of the project, attempts to 
 * simulate a technicolor firework show, with multiple circles drawn with randomly
 * chosen lines -- each circle is drawn with 1,440 lines.  The result is a screen full
 * of dynamic color.  The Math.sin() and Math.cos() functions were both used to 
 * change the coordinates for the drawLine() function on every iteration.  
 * Method: RainbowExplosion.
 * 
 * Additional notes are provided throughout the script below.
 * 
 * @author Martin Dwyer
 * @version 11/12/2017
 */

public class GraphicDisplayFun  {
    public static void main(String [] args)   {
        String choice = null;
        Scanner kb = new Scanner(System.in);
        do     {
            // show menu
            System.out.println("Choose from the gallery:");
            // get user's choice
            System.out.println("1. Random Confetti");   
            System.out.println("2. Connected Rectangles.");
            System.out.println("3. Cascading Circles.");
            System.out.println("4. Technicolor 3D Tunnel.");
            System.out.println("5. Rainbow Explosion.");
            System.out.print("Type a number or Q to quit: ");
            choice = kb.nextLine();
            // call method to display pic (or quit)
            if (choice.equals("1"))
                displayPic(drawRandomConfetti()); 
            if (choice.equals("2"))
                displayPic(drawConnectedRectangles());
            if (choice.equals("3"))
                displayPic(drawCascadingCircles());
            if (choice.equals("4"))
                displayPic(drawTechnicolorTunnel());
            if (choice.equals("5"))
                displayPic(drawRainbowExplosion());

        } while (!choice.equalsIgnoreCase("q"));
    }

    public static void displayPic(JFrame picture)   {
        picture.setSize(500,500);
        picture.setAlwaysOnTop(true);
        picture.setVisible(true);
    }

    public static JFrame drawRandomConfetti() {   
        JFrame picture = new JFrame () {        
                Color c = null;             
                Random rg = new Random();
                public void paint(Graphics g)
                {
                    super.paint(g);
                    for(int x = 0; x < 500; x++)   {
                        c=new Color(rg.nextInt(255),rg.nextInt(255),rg.nextInt(255));
                        g.setColor(c);
                        for (int y = 0; y < 10; y++)   {
                            g.fillRect(rg.nextInt(450)+20,rg.nextInt(450)+ 20,20,20);
                        }
                    }
                }
            };
        return picture;
    }

    public static JFrame drawConnectedRectangles() {   
        JFrame picture = new JFrame () {        
                Color c = null;             
                Random rg = new Random();
                public void paint(Graphics g)
                {
                    super.paint(g);
                    for(int x = 50; x < 300; x=x+25)   {
                        c=new Color(rg.nextInt(255),rg.nextInt(255),rg.nextInt(255));
                        g.setColor(c);
                        g.fillRect(x,x,200,200);
                    }
                    c = new Color(0,0,0);    
                    g.setColor(c);
                    g.drawLine(50,50,275,275);
                    g.drawLine(50,250,275,475);
                    g.drawLine(250,50,475,275);
                }
            };
        return picture;
    }

    public static JFrame drawCascadingCircles() {
        JFrame picture = new JFrame () {        
                Color c = null;             
                Random rg = new Random();
                public void paint(Graphics g)
                {
                    super.paint(g);
                    for(int x = 50; x < 300; x=x+25)   {
                        c=new Color(rg.nextInt(255),rg.nextInt(255),rg.nextInt(255));
                        g.setColor(c);
                        g.fillOval(x,x,200,200);
                    }
                    c = new Color(0,0,0);    
                    g.setColor(c);
                    g.drawLine(50,50,275,275);
                    g.drawLine(50,250,275,475);
                    g.drawLine(250,50,475,275);
                }
            };
        return picture;
    }

    public static JFrame drawTechnicolorTunnel() {
        JFrame picture = new JFrame () {        
                Color c = null;             
                Random rg = new Random();
                public void paint(Graphics g)
                {
                    super.paint(g);
                    double d;   // variable used to keep radian calculation separate below
                    double q;   // variable used to reset size of circle on each iteration
                                // note that the range of the sine function to operate on is
                                // from zero to 5*Math.PI, offering just over two full cycles
                                // to be presented on the screen.

                    for(int x = 1; x < 350; x=x+1)   {
                        c=new Color(rg.nextInt(255),rg.nextInt(255),rg.nextInt(255));
                        g.setColor(c);    
                        d = 250 + 150*Math.sin(5*Math.PI*((double)x/350));
                        q = 7 + (143*((double)x/350));
                        g.fillOval(x,(int)d,(int)q,(int)q);
                        if (x == 349) {
                            c=new Color(100,100,100);
                            g.setColor(c);   
                            g.fillOval(349,(int)d,(int)q,(int)q);
                        }

                    }

                }
            };
        return picture;

    }

    public static JFrame drawRainbowExplosion() {
        JFrame picture = new JFrame () {        
                Color c = null;             
                Random rg = new Random();
                int width;
                int height;
                public void paint(Graphics g)
                {
                    super.paint(g);
                    int t = 400;        //  This method uses drawLine to fill circle objects
                    int u = 250;        //  on the screen.  Each iteration of the program is 
                                        //  intended to find new coordinates for the drawLine()
                                        //  method after moving over 1%, using the Sine and 
                                        //  Cosine functions and the known measure of degrees
                                        //  rotation.  The result is controlled images which 
                                        //  could be placed anywhere on the screen, which appear
                                        //  filled with thousands of colored lines.  
                                        
                    for(int i = 100; i < 425; i = i + 150) {

                        for(int x = 0; x < 1440; x=x+1)   {
                            c=new Color(rg.nextInt(255),rg.nextInt(255),rg.nextInt(255));
                            g.setColor(c);
                            g.drawLine(250,250,t,u);
                            t = (int)(250 + 150*Math.cos(x));
                            u = (int)(i + 150*Math.sin(x));
                        }
                    }
                    for(int i = 100; i < 1440; i = i + 150) {

                        for(int x = 0; x < 720; x=x+1)   {
                            c=new Color(rg.nextInt(255),rg.nextInt(255),rg.nextInt(255));
                            g.setColor(c);
                            g.drawLine(250,250,t,u);
                            t = (int)(i + 150*Math.cos(x));
                            u = (int)(250 + 150*Math.sin(x));
                        }
                    }
                } 
            }; 
        return picture;
    }

}