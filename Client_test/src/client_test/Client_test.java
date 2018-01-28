/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_test;

/**
 *
 * @author rezwan
 */
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.*;
import java.io.*;
import static java.time.Instant.now;
public class Client_test {

	public static void main (String [] args ) throws IOException {
	    int filesize=1024*1024*10; 
	    int bytesRead;
	    int currentTot = 0;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
            Calendar now = Calendar.getInstance();
	    Socket socket = new Socket("192.168.123.4",15123);
	    byte [] bytearray  = new byte [filesize];
	    InputStream is = socket.getInputStream();
            
	    FileOutputStream fos = new FileOutputStream("E:\\"+formatter.format(now.getTime())+".jpg");
            
          
	    BufferedOutputStream bos = new BufferedOutputStream(fos);
	    bytesRead = is.read(bytearray,0,bytearray.length);
	    currentTot = bytesRead;

	    do {
	       bytesRead =
	          is.read(bytearray, currentTot, (bytearray.length-currentTot));
	       if(bytesRead >= 0) currentTot += bytesRead;
               
	    } while(bytesRead > -1);

	    bos.write(bytearray, 0 , currentTot);
	    bos.flush();
	    bos.close();
	    socket.close();
	  }
}

