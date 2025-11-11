/**

 * Kevin Hayes

 * Test Picture Classes

 *

 * @author (Kevin Hayes)

 * @version (10-19-2016)

 */

import java.awt.*;//the color class in awt lib

import java.util.*;

import java.util.List; // resolves problem with java.awt.List and java.util.List

public class TestPicture17

{

 

    /**

     * main method, to test the picture

     *

     */

  public static void main(String[] args)

  {

      //opens picture using a dialog box

      /*

     String fileName = FileChooser.pickAFile();

     Picture pictObj = new Picture(fileName);

     pictObj.explore();*/

 

     //opens a pictue using a path

     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");

     

     //Know it, Love it, Live it!!!!!!!!!!!!!!!!!

     //relative path            dir/folder/file

     Picture apic = new Picture("images\\beach.jpg");

     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");

     Picture moto = new Picture("images/blueMotorcycle.jpg");

     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");

     

         

     

     apic.explore();//!!!!!!!!!!!displays the pic

     ferris1.explore();

     moto.explore();

     

     //to change color of pic get all of the pixels!!!!!!!!!

     //makes an array of pixels

     Pixel[] pixels;

     //gets pixels from picture and assigns to pixels array

     pixels = ferris1.getPixels();

   

     //how many pixels or how large array

    System.out.println("This is a large array"+pixels.length  );

 

 

    /**/

    //access each index,array note

    System.out.println(pixels[17]);

    //access each pixel pic.methos.getPixel

    Pixel spot = ferris1.getPixel(100,100);

    Pixel spot50 = ferris1.getPixel(50,50);

   

    Color ltsteel = new Color(176,196,222);

   

    System.out.println(pixels[17].getColor());

    System.out.println(spot);

   

    Pixel spot17 = pixels[17];

    spot17.setRed(200);

    spot17.setBlue(150);

    spot17.setGreen(175);

   

   

    spot.setColor(Color.yellow);

    spot50.setColor(ltsteel);

    ferris1.explore();

    /*

    pixels[17].setColor(Color.blue);

    spot.setColor(new Color(252,252,252));

    pixels[500034].setColor(Color.blue);

 

    ferris1.explore();

    /**/

   // loop to access indexes of array or collection

 

    //for each loop spot  is a ?

    /*

    int red;

    for (Pixel spot1 : pixels)

    {

        //System.out.println( spot1 );

        red=spot1.getRed();

        red = (int)(red *.25);

        spot1.setRed(red);

    }

    ferris1.explore();

   

    int blue;

    for (Pixel spot1 : pixels)

    {

        blue = spot1.getBlue();

        blue = (int)(Math.random()*2 * blue);

        spot1.setBlue(blue);

    }

    ferris1.explore();

    */

     int green;

     int count = 0;

    for (Pixel spot1 : pixels)

    {

        if (count%20 == 0)

            spot1.setColor(Color.yellow);

           

        count++;

    }

    ferris1.explore();

 

 

   

 /**/

 

 /**

  * Method to clear red from picture

  * @param none

  * @return none

  */

 /*

    for (Pixel pixelObj : pixels)

        {

            //set the red value of the current pixel to the new value

           

 

        }

    ferris1.explore();

   

    /**/

 /**

  * Method to reduce red from picture by a factor of n

  * @param none

  * @return none

  */

 

    /*

    int value;

    final double  FACTOR = .5;

        for (Pixel pixelObj : pixels)

        {

 

        //get the redvalue

        value = pixelObj.getRed();

        //System.out.println(value);

 

        //decrease the red value by 50%

       

        //set the red value of the current pixel to the new value

       

 

    }

    // use new picture when changing or it will make changes to

    // pic you already changed

    ferris1.explore();

    ferris2.explore();

 

  /**/

    //write/save a picture as a file

    ferris1.write("images/ferris11.jpg");

 

    /**/

  }//main

}//class