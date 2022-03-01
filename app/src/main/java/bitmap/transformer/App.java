/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import bitmap.transformer.bitmapApp.bitmap;

public class App {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file path");
        String infile = scanner.nextLine();//C:\\Users\\ghl1590\\java\\sample.bmp
        System.out.println("Please enter the file save path");
        String outfile = scanner.nextLine();//C:\\Users\\ghl1590\\java\\new.bmp
        System.out.println("Please enter the Transform type (rotateImage-flip-grayscale)");
        String transform = scanner.nextLine();

        bitmap map = new bitmap();

        if(transform.equals("rotateImage")){
            map.rotateImage(infile, outfile);
        }else if(transform.equals("flip")){
            map.flip(infile, outfile);
        }else if (transform.equals("grayscale")){
            map.grayscale(infile, outfile);
        }else {
            System.out.println("there are no transform like this");
        }
    }
}
