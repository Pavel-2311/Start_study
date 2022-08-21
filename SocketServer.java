package ru.specialist.processtart2;

/* задача сервер должен связаться с клиентом, клиент отправит
ему строку и получит от него
эту же строку в верхнем регистре (сервер эхо).
выводить в консоль от кого пришел запрос и количество запросов
 */
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class SocketServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        // 127.0.0.1:1111  это локальная машина
        ServerSocket ss = new ServerSocket(1111);
        int req = 0; // это количество запросов

        while (true) {
            Socket cs = ss.accept(); // accept  приостанавливает работу текущего потока
            // до тех пор пока не будет установлено соединение
            // т.е. просто ждем пока придет запрос
            System.out.println("Accept connection from :" + cs.getInetAddress().toString());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8"))
            );

            String s = reader.readLine();
            ++req;
            System.out.printf("%s . %d\n", s, ++req);

            Thread.sleep(100);

            OutputStreamWriter writer = new OutputStreamWriter(
                    cs.getOutputStream(), Charset.forName("UTF-8"));

            writer.write(s.toUpperCase() + "\n");
            writer.flush(); //Записывает в поток все данные, которые хранятся в буфере

            if (s.equals("stop")) {
                ss.close();
                writer.close();
                cs.close();
                break;
            }
        }
    }
}
