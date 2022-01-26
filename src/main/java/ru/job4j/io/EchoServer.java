package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static void sendAnswerFromServer(OutputStream out, String message) throws IOException {
        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        out.write(message.getBytes());
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                String message = "";
                int iterator = 0;
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (0 == iterator) {
                            message = str;
                            iterator++;
                        }
                        System.out.println(str);
                    }
                    if (message.matches(".*\\s/\\?msg=Exit\\s.*")) {
                        sendAnswerFromServer(out, "Shut down the server.");
                        server.close();
                    } else if (message.matches(".*\\s/\\?msg=Hello\\s.*")) {
                        sendAnswerFromServer(out, "Hello.");
                    } else {
                        sendAnswerFromServer(out, "What.");
                    }
                    out.flush();
                }
            }
        }
    }
}
