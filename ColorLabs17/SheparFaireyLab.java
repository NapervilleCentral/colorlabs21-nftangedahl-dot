
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
        //save method 1
        image.explore();  
        image.write("images/ShepardFairey.jpg");
         
        //method 2
        //find smallest and largest grayscale values
        Picture image2 = new Picture("images/mepic.JPG");

        //find min and max gray
        int smallest = 255;
        int biggest = 0;
        //loop to get all the pixels and their grayscale
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

        // loop to recolor image
        for (Pixel p : image2.getPixels())
        {
            int gray = (p.getRed() + p.getGreen() + p.getBlue()) / 3;

            //Apply intensity-based grouping
            if (gray < cut1)
                p.setColor(darkBlue2);
            else if (gray < cut2)
                p.setColor(red2);
            else if (gray < cut3)
                p.setColor(lightBlue2);
            else
                p.setColor(offWhite2);
        }
        //save second method
        image2.explore();  
        image2.write("images/intense.jpg");
    
        //method 3 
        Picture image3 = new Picture("images/mepic.JPG");
    

        //loops to look at every pixel
        for (Pixel p : image3.getPixels())
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();

            //grayscale
            int gray = (r + g + b) / 3;

            //custom palette
            Color color1 = new Color(75, 37, 21);    // dark brown
            Color color2 = new Color(210, 180, 140); // tan
            Color color3 = new Color(34, 139, 34);   // green
            Color color4 = new Color(255, 215, 0);   // yellow

            //simple grayscale thresholds
            if (gray < 64)
                p.setColor(color1);
            else if (gray < 120)
                p.setColor(color2);
            else if (gray < 192)
                p.setColor(color3);
            else
                p.setColor(color4);
        }
        //save try 1
        image3.explore();
        image3.write("images/SFtry1.jpg");   
        
        
        //Method 3 try 2 (your custom palette)
        Picture image4 = new Picture("images/mepic.JPG");
        
        // loops to look at every pixel
        for (Pixel p : image4.getPixels())
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();
        
            //grayscale
            int gray = (r + g + b) / 3;
        
            //new palette colors
            Color color1 = new Color(170, 0, 74);   //deep magenta/red
            Color color2 = new Color(13, 52, 134);  //strong blue
            Color color3 = new Color(201, 133, 0);  //gold
            Color color4 = new Color(107, 184, 0);  //green
        
            //thresholds
            if (gray < 70)
                p.setColor(color1);
            else if (gray < 140)
                p.setColor(color2);
            else if (gray < 200)
                p.setColor(color3);
            else
                p.setColor(color4);
        }
        //save try 2
        image4.explore();
        image4.write("images/SFtry2.jpg");    


        //Method 3 try 3 (higher contrast version)
        Picture image5 = new Picture("images/mepic.JPG");

        for (Pixel p : image5.getPixels())
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();

            //grayscale boosted
            int gray = (int)((r + g + b) / 3 * 1.6);
            if (gray > 255) gray = 255;

            // same palette as try 2 to enhance
            Color color1 = new Color(170, 0, 74);
            Color color2 = new Color(13, 52, 134);
            Color color3 = new Color(201, 133, 0);
            Color color4 = new Color(107, 184, 0);

            if (gray < 80)
                p.setColor(color1);
            else if (gray < 150)
                p.setColor(color2);
            else if (gray < 210)
                p.setColor(color3);
            else
                p.setColor(color4);
        }
        //save try 3
        image5.explore();
        image5.write("images/SFtry3.jpg"); 


        //Method 3 final
        Picture image6 = new Picture("images/mepic.JPG");
        //gets all pixels and assigns values
        for (Pixel p : image6.getPixels())
        {
            int r = p.getRed();
            int g = p.getGreen();
            int b = p.getBlue();

            int gray = (int)((r + g + b) / 3 * 1.3);
            if (gray > 255) gray = 255;

            // final palette
            Color color1 = new Color(150, 0, 65);
            Color color2 = new Color(20, 70, 150);
            Color color3 = new Color(220, 150, 10);
            Color color4 = new Color(120, 200, 20);
            //buckets
            if (gray < 75)
                p.setColor(color1);
            else if (gray < 145)
                p.setColor(color2);
            else if (gray < 205)
                p.setColor(color3);
            else
                p.setColor(color4);
        }
        //final save
        image6.explore();
        image6.write("images/SFmyFinal.jpg"); 
    }
}



         
         
         

        
