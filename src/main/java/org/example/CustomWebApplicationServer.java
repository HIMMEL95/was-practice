package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clienSokcet;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clienSokcet = serverSocket.accept()) != null) {
                logger.info("[CustomeWebApplicationServer] client connected!");

                /*
                * Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                */

                try (InputStream in = clienSokcet.getInputStream(); OutputStream out = clienSokcet.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);
                    /*프로토콜을 보여주는 부분
                    String line;
                    while ((line = br.readLine()) != "") {
                        System.out.println(line);
                    }*/


                }
            }
        }
    }
}
