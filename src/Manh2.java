
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Manh2 {
    public static void main(String args[]) throws IOException{
        Socket socket = new Socket("10.10.10.11",808);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        String s="B20DCCN426;700";
        dos.write(s.getBytes());
        dos.flush();
        
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String re = reader.readLine();
        String[] list=re.split(", ");
        StringBuilder eduBuilder =new StringBuilder();
        for(String x : list){
            if(x.endsWith(".edu")){
                eduBuilder.append(x).append(", ");
            }
        }
        String a =eduBuilder.toString();
        if(a.length()>0){
            a = a.substring(0,a.length()-2);
        }
        dos.write(a.getBytes());
    }
}
