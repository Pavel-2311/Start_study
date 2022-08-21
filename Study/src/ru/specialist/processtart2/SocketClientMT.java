package ru.specialist.processtart2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketClientMT {

    public static final int CONNECTIONS = 100;

    public static void main(String[] args) throws IOException {
        Runnable task = () -> {
            try {
                Socket cs = new Socket("localhost", 1111);
                OutputStreamWriter writer = new OutputStreamWriter(cs.getOutputStream(),
                        Charset.forName("UTF-8"));
                writer.write("test: " + String.valueOf(Thread.currentThread().getId()) + "\n");
                writer.flush();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(cs.getInputStream(),
                                Charset.forName("UTF-8")));
                System.out.println(reader.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(CONNECTIONS);
        for (int i = 0; i < CONNECTIONS; i++) {
            pool.submit(task);
        }
        pool.shutdown();
    }
}
