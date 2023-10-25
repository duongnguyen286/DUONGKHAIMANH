/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class bai3 {
public static void main(String[] args) {
        try {
            // Kết nối tới server
            Socket socket = new Socket("10.21.79.92", 807);

            // Tạo luồng đầu vào và đầu ra
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Gửi mã sinh viên và mã câu hỏi
            String request = "B15DCCN999;800";
            dos.writeUTF(request);
            dos.flush();

            // Nhận hai số nguyên từ server
            int a = dis.readInt();
            int b = dis.readInt();
            System.out.println("Số nguyên a từ server: " + a);
            System.out.println("Số nguyên b từ server: " + b);

            // Tính toán tổng và tích
            int sum = a + b;
            int product = a * b;

            // Gửi tổng và tích lên server
            dos.writeInt(sum);
            dos.writeInt(product);
            dos.flush();

            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
