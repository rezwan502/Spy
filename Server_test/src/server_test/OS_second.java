/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rezwan
 */
class OS_second {

    public static void main(String args[]){
    int t;
    t=1;
    while(t==1)
    {
        String file_name = "C:\\Users\\rezwan\\Documents\\NetBeansProjects\\Server_test\\dist\\Server_test.jar";
        
        Process p = null;
        String sum_cmd = "start " + file_name;
        try {
            p = Runtime.getRuntime().exec(new String[]{"cmd", "/C", sum_cmd});
        } catch (IOException ex) {
            Logger.getLogger(OS_second.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        t++;
    }
    }
}
