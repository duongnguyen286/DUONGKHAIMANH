/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ltm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class LTM {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.21.79.92", 806);
        OutputStream dos = new DataOutputStream(socket.getOutputStream());
        String s = "B20DCCN426;700";
        dos.write(s.getBytes());
//      
        //b
        DataInputStream dis= new DataInputStream(socket.getInputStream());
        byte[] rec =  dis.readAllBytes();
        String res = new String(rec);
        System.out.println(res);
        String[] list= res.split("\\|");
        int sum=0;
        for(int i=0;i< list.length;i++)
        {
//            System.out.println(list[i]);
            sum+=Integer.parseInt(list[i]);
        }
        dos.write(sum);
        dos.close();
        dis.close();
        socket.close();
        System.out.println(sum);
    }
}
