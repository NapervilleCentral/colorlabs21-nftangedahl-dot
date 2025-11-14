
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.Color; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
         //method 1
         Picture image = new Picture("images/mepic.JPG");
         image.explore();
         
         //loops to look at every pixel
         for (Pixel p : image.getPixels()){
             int r = p.getRed();
             int g = p.getGreen();
             int b = p.getBlue();
             //grayscale
             int gray = (r + g + b) / 3;
             
             //Fairey colors
             Color darkBlue = new Color(0,51,76);
             Color red = new Color(217,26,33);
             Color lightBlue = new Color(112,150,158);
             Color offWhite = new Color(252,227,166);
             
             if (gray < 64) p.setColor(darkBlue);
             else if (gray < 120) p.setColor(red);
             else if (gray < 192) p.setColor(lightBlue);
             else p.setColor(offWhite);
             
           
             
         }
        image.explore();

         
        //method 2
        // First pass: find smallest and largest grayscale values
        int smallest = 255;
        int biggest = 0;

        // Define Fairey palette
        Color darkBlue  = new Color(0,51,76);
        Color red       = new Color(217,26,33);
        Color lightBlue = new Color(112,150,158);
        Color offWhite  = new Color(252,227,166);
        
        for (Pixel p : image.getPixels())
        {
        int gray = (int)(0.3*p.getRed() + 0.59*p.getGreen() + 0.11*p.getBlue());
        if (gray < smallest) smallest = gray;
        if (gray > biggest)  biggest = gray;
        }

    // use doubles to avoid step = 0
        double range = biggest - smallest;
        double step = range / 4.0;

        double cut1 = smallest + step;
        double cut2 = smallest + 2 * step;
        double cut3 = smallest + 3 * step;

        // second pass
        for (Pixel p : image.getPixels())
        {
        int gray = (int)(0.3*p.getRed() + 0.59*p.getGreen() + 0.11*p.getBlue());

        if (gray < cut1)
            p.setColor(darkBlue);
        else if (gray < cut2)
            p.setColor(red);
        else if (gray < cut3)
            p.setColor(lightBlue);
        else
            p.setColor(offWhite);
}

        image.explore(); 
         
         /**
          * custom color palette
          */

         
    }//main       
}//class
