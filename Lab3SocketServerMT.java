package ru.specialist.processtart2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Lab3SocketServerMT {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket ss = new ServerSocket(1111);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        AtomicInteger req = new AtomicInteger();

        while (true) {
             final Socket cs = ss.accept();
            Runnable task = () -> {
                try {
                   
                    System.out.println("Accept connection from :" + cs.getInetAddress().toString());

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8"))
                    );

                    String s = reader.readLine();
                    
                    System.out.println(s + req.incrementAndGet());

                    Thread.sleep(100);

                    OutputStreamWriter writer = new OutputStreamWriter(
                            cs.getOutputStream(), Charset.forName("UTF-8"));

                    writer.write(s.toUpperCase() + "\n");
                    writer.flush();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            };
            pool.submit(task);

            pool.shutdown();
        }
    }
}
