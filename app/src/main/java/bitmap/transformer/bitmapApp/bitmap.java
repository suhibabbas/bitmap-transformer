package bitmap.transformer.bitmapApp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bitmap {

    public void grayscale (String infile, String outFile){


        BufferedImage bmp = null;
        File file = null;
        // read
        try {

            file = new File(infile);//"C:\\Users\\ghl1590\\java\\sample.bmp"
            bmp = ImageIO.read(file);
            System.out.println("done");
        }catch (IOException exception) {
            System.out.println(exception);
        }

        //get image width and height
        int width = bmp.getWidth();
        int height = bmp.getHeight();

        //convert to grayscale

        for(int y = 0 ; y < height;y++){
            for (int x = 0 ; x < width;x++){
                Color color = new Color(bmp.getRGB(x,y));
                int red = (int)(color.getRed()* 0.2126);
                int green = (int)(color.getGreen()* 0.7152);
                int blue = (int)(color.getBlue()* 0.0722);
                int sum = red + green + blue;
                Color gray = new Color(sum,sum,sum);
                bmp.setRGB(x,y, gray.getRGB());
            }
        }

        //write image
        try {
            file = new File(outFile);//"C:\\Users\\ghl1590\\java\\new.bmp"
            ImageIO.write(bmp,"bmp",file);
        }catch (IOException exception){
            System.out.println(exception);
        }
    }

    public void rotateImage (String infile,String outFile){
        BufferedImage bmp = null;
        File file = null;
        // read
        try {

            file = new File(infile);//"C:\\Users\\ghl1590\\java\\sample.bmp"
            bmp = ImageIO.read(file);
            System.out.println("done");
        }catch (IOException exception) {
            System.out.println(exception);
        }

        //get image width and height
        int width = bmp.getWidth();
        int height = bmp.getHeight();

        //Rotate the image
        BufferedImage rotated = new BufferedImage(height,width,bmp.getType());

        for(int y = 0 ; y < height ;y++){
            for (int x = 0;x < width;x++){
                rotated.setRGB(y,(width-1) -x, bmp.getRGB(x,y));
            }
        }
        //write image
        try {
            file = new File(outFile);//"C:\\Users\\ghl1590\\java\\new.bmp"
            ImageIO.write(rotated,"bmp",file);
        }catch (IOException exception){
            System.out.println(exception);
        }

    }

    public void flip(String infile, String outfile ){

        BufferedImage bmp = null;
        File file = null;
        // read
        try {

            file = new File(infile);//"C:\\Users\\ghl1590\\java\\sample.bmp"
            bmp = ImageIO.read(file);
            System.out.println("done");
        }catch (IOException exception) {
            System.out.println(exception);
        }

        //get image width and height
        int width = bmp.getWidth();
        int height = bmp.getHeight();

        //Rotate the image

        BufferedImage flipped = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        try {
            for(int y = 0 ; y < height ;y++){
                for (int x = 0;x < width;x++){
                    flipped.setRGB((width - 1) -x, y,bmp.getRGB(x,y));

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }


        //write image
        try {
            file = new File(outfile);//"C:\\Users\\ghl1590\\java\\new.bmp"
            ImageIO.write(flipped,"bmp",file);
        }catch (IOException exception){
            System.out.println(exception);
        }

    }
}
