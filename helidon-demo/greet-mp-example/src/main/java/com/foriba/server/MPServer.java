package com.foriba.server;

import com.foriba.service.GreetService;
import io.helidon.microprofile.server.Server;

public class MPServer {

    public static void main(String[] args) {

        Server server
                = Server.builder()
                .port(8080)
                .addResourceClass(GreetService.class)
                .build();

        server.start();

    }
}
