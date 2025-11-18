
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (Nick Tangedahl) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.awt.Color; 

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
        //find smallest and largest grayscale values
        Picture image2 = new Picture("images/mepic.JPG");

        //find min and max gray
        int smallest = 255;
        int biggest = 0;

        for (Pixel p : image2.getPixels())
        {
            int gray = (p.getRed() + p.getGreen() + p.getBlue()) / 3;

            if (gray < smallest) smallest = gray;
            if (gray > biggest)  biggest = gray;
        }

        //compute interval cuts
        double range = biggest - smallest;
        double step  = range / 4.0;

        double cut1 = smallest + step;
        double cut2 = smallest + 2 * step;
        double cut3 = smallest + 3 * step;

        //Fairey colors
        Color darkBlue2  = new Color(0,51,76);
        Color red2       = new Color(217,26,33);
        Color lightBlue2 = new Color(112,150,158);
        Color offWhite2  = new Color(252,227,166);

        // loop recolor image
        for (Pixel p : image2.getPixels())
        {
            int gray = (p.getRed() + p.getGreen() + p.getBlue()) / 3;

            // Apply intensity-based grouping
            if (gray < cut1)
                p.setColor(darkBlue2);
            else if (gray < cut2)
                p.setColor(red2);
            else if (gray < cut3)
                p.setColor(lightBlue2);
            else
                p.setColor(offWhite2);
        }

        image2.explore();
        
    
        //method 3 TRY 1
        /*
        Picture image3 = new Picture("images/mepic.JPG");
    

        // loops to look at every pixel
        for (Pixel p : image3.getPixels())
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();

            // grayscale
            int gray = (r + g + b) / 3;

            //custom palette colors
            Color color1 = new Color(170, 0, 74);   // deep red/magenta
            Color color2 = new Color(13, 52, 134);  // deep blue
            Color color3 = new Color(201, 133, 0);  // gold
            Color color4 = new Color(107, 184, 0);  // green

            // simple grayscale thresholds
            if (gray < 64)
                p.setColor(color1);
            else if (gray < 120)
                p.setColor(color2);
            else if (gray < 192)
                p.setColor(color3);
            else
                p.setColor(color4);
        }

        image3.explore();
        image3.write("images/SFtry1.jpg");   // save Method 3 Try 1
        */
        
        
        //Method 3 try 2
        Picture image4 = new Picture("images/mepic.JPG");
        
        // loops to look at every pixel
        for (Pixel p : image4.getPixels())
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();
        
            // grayscale
            int gray = (r + g + b) / 3;
        
            // boost contrast to avoid muddy image
            gray = (int)(gray * 1.4);
            if (gray > 255) gray = 255;
        
            // NEW palette colors
            Color color1 = new Color(170, 0, 74);   // deep magenta/red
            Color color2 = new Color(13, 52, 134);  // strong blue
            Color color3 = new Color(201, 133, 0);  // gold
            Color color4 = new Color(107, 184, 0);  // green
        
            // thresholds (much cleaner now)
            if (gray < 70)
                p.setColor(color1);
            else if (gray < 140)
                p.setColor(color2);
            else if (gray < 200)
                p.setColor(color3);
            else
                p.setColor(color4);
        }

        image4.explore();
        image4.write("images/SFmyFinal.jpg");    // final custom version
        
    }
}


         
         
         

        
