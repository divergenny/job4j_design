package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                String message = "";
                int iterator = 0;
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (0 == iterator) {
                            message = str;
                            iterator++;
                        }
                        System.out.println(str);
                    }
                    message = message.substring(message.indexOf("=") + 1, message.indexOf("HTTP"));
                    message = message.trim();
                    if ("Bye".equals(message)) {
                        System.out.println("Server end the work. Bye!");
                        server.close();
                    }
                    out.flush();
                }
            }
        }
    }
}
