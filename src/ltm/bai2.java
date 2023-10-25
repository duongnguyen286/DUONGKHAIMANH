/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm;

/**
 *
 * @author DELL
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
public class bai2 {
    public static void main(String[] args) {
        try {
            // Kết nối tới server
            Socket socket = new Socket("10.21.79.92", 808);

            // Tạo các luồng đầu vào và đầu ra
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Gửi mã sinh viên và mã câu hỏi
            String request = "B15DCCN999;600";
            writer.write(request);
            writer.newLine();
            writer.flush();

            // Nhận danh sách các tên miền từ server
            String response = reader.readLine();
            System.out.println("Danh sách tên miền ngẫu nhiên từ server:");
            System.out.println(response);

            // Tìm kiếm và gửi các tên miền .edu
            String[] domainList = response.split(", ");
            StringBuilder eduDomains = new StringBuilder();
            for (String domain : domainList) {
                if (domain.endsWith(".edu")) {
                    eduDomains.append(domain).append(", ");
                }
            }
            String eduDomainsString = eduDomains.toString();
            if (eduDomainsString.length() > 0) {
                eduDomainsString = eduDomainsString.substring(0, eduDomainsString.length() - 2);
            }
            writer.write(eduDomainsString);
            writer.newLine();
            writer.flush();

            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
