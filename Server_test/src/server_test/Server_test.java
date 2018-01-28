/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_test;

/**
 *
 * @author rezwan
 */

import java.net.*;
import java.io.*;

public class Server_test {

    public void robo() throws Exception {
     
        ServerSocket serverSocket = new ServerSocket(15123);
            
        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection : " + socket);
        File transferFile = new File("d:\\a\\a.jpg");
        byte[] bytearray = new byte[(int) transferFile.length()];
        FileInputStream fin = new FileInputStream(transferFile);
        BufferedInputStream bin = new BufferedInputStream(fin);
        bin.read(bytearray, 0, bytearray.length);
        OutputStream os = socket.getOutputStream();
        System.out.println("Sending Files...");
        os.write(bytearray, 0, bytearray.length);
       // Thread.sleep(1000);
        
             os.flush();
            socket.close();
        
        }
    

    public static void main(String[] args) throws IOException, Exception {
        Server_test s2i = new Server_test();
          s2i.robo();
        
         //System.exit(0);
    }

}
