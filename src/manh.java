
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class manh {
    public static void main(String args[]) throws IOException{
        //kết nối đến sever
        Socket socket = new Socket("19.12.12.12",806);
        //tạo luồng đầu vào,ra
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // gửi mã sinh viên và câu hỏi
        String s="B20DCCN426;700";
        dos.write(s.getBytes());
        //nhận dữ liệu từ serer
        byte[] rec=dis.readAllBytes();
        String res = new String(rec);
        String[] list =res.split("\\|");
        int sum = 0;
        for(int i=0;i<list.length;i++){
            sum+=Integer.parseInt(list[i]);
        }
        dos.write(sum);
        dos.close();
        dis.close();
        socket.close();
    }
}
