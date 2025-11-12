
/**
 * Write a description of class colorlabs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ManipulationOfColorsLab
{
    public static void main(String[] args)
    {
        Picture image = new Picture("images/butterfly1.jpg");
        image.explore();  // show original

        // adjust red
        for (Pixel p : image.getPixels())
        {
            int newRed = (int)(p.getRed() * 0.5);
            p.setRed(newRed);
        }
        image.explore();

        // adjust green
        for (Pixel p : image.getPixels())
        {
            int newGreen = (int)(p.getGreen() * 1.5);
            if (newGreen > 255) newGreen = 255;
            p.setGreen(newGreen);
        }
        image.explore();

        // adjust blue
        for (Pixel p : image.getPixels())
        {
            int newBlue = (int)(p.getBlue() * 0.25);
            p.setBlue(newBlue);
        }
        image.explore();

        // negative
        for (Pixel p : image.getPixels())
        {
            p.setRed(255 - p.getRed());
            p.setGreen(255 - p.getGreen());
            p.setBlue(255 - p.getBlue());
        }
        image.explore();

        // grayscale
        for (Pixel p : image.getPixels())
        {
            int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
            p.setRed(avg);
            p.setGreen(avg);
            p.setBlue(avg);
        }
        image.explore();

        //lighten
        for (Pixel p : image.getPixels())
        {
            p.setRed(Math.min(255, p.getRed() + 20));
            p.setGreen(Math.min(255, p.getGreen() + 20));
            p.setBlue(Math.min(255, p.getBlue() + 20));
        }
        image.explore();

        //darken
        for (Pixel p : image.getPixels())
        {
            p.setRed(Math.max(0, p.getRed() - 20));
            p.setGreen(Math.max(0, p.getGreen() - 20));
            p.setBlue(Math.max(0, p.getBlue() - 20));
        }
        image.explore();

        // changecolor
        for (Pixel p : image.getPixels())
        {
            p.setRed(Math.min(255, p.getRed() + 40));
            p.setGreen(Math.min(255, p.getGreen() + 10));
            p.setBlue(Math.max(0, p.getBlue() - 30));
        }
        image.explore();

        
       
    }
}