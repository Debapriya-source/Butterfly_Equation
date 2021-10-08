
package butterfly;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;


public class ButterFly extends JFrame{
    
    private int WIDTH=800,HEIGHT=800;
     private int scale=80;//start=-3,end=3;
    double x,y,u=0;
   
    Random rand = new Random();
    
    ButterFly(){
         setSize(WIDTH,HEIGHT);
        setTitle("My Grapher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        
    }
    @Override
    public void paint(Graphics g){
        g.translate(WIDTH/2, HEIGHT/2);
        
       // if(x<=-1.78) y=f(-1.78);
       // else if(x>=1.78) y=f(1.78);
        //else  y=f(x);
        x=getX(u);
        y=getY(u);
        
        if(x==getX(0)){
             g.setColor(Color.BLACK);
                g.fillRect(-WIDTH, -HEIGHT, WIDTH*2, HEIGHT*2);
        }
        /*if(x>end){
        
        g.setColor(Color.BLACK);
        g.fillRect(-WIDTH, -HEIGHT, WIDTH*2, HEIGHT*2);
        u+=scale;
        x=start;
        }*/
        float red= 0,green=rand.nextFloat(),blue=rand.nextFloat();
        
        Color newColor = new Color(red,green,blue);
        g.setColor(newColor);
        //g.setColor(Color.yellow);
        g.fillOval((int)(scale*x), (int)(y*scale), 3, 3);
       
        
        
        run();
        
        repaint();
        
    }
    public void run(){
        try {
            Thread.sleep(1);
            
            //if(x>=start && x<=end){
                /*oldX=x;
                oldY=y;*/
                u+=.017;//scale;         
            //}
            /* if(x>5){
            
            oldX=x;
            oldY=y;
            x=-5;
            }*/
            //System.out.println(x+","+y);
        } catch (InterruptedException e) {
            System.out.println("Error!!!");
        }
        
    }
    /*double f(double x){
    return -1*(Math.pow(Math.abs(x), 2.0/3.0)+((0.9*Math.sqrt(3.3-(x*x)))*(Math.sin(a*3.14*x*(3.14/180))))); //Heart Wave
    
    }*/
    double getX(double u){
        return Math.sin(u)*(Math.pow(Math.E,Math.cos(u))-(2*Math.cos(4*u))-(Math.pow(Math.sin(u/12), 5)));
        
    }
     double getY(double u){
        return -1*Math.cos(u)*(Math.pow(Math.E,Math.cos(u))-(2*Math.cos(4*u))-(Math.pow(Math.sin(u/12), 5)));
        
    }
    
    public static void main(String[] args) {
        new ButterFly();
    }
    
}
