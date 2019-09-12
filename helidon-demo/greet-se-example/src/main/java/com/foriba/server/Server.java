package com.foriba.server;

import com.foriba.service.GreetService;
import io.helidon.webserver.*;

public class Server {

    public static void main(String[] args) {

        WebServer server = WebServer.create(
                Server::createConfiguration,
                Server::createRouting);

        server.start()
            .whenComplete((webServer, throwable) -> System.out.println("http://localhost:"+ webServer.port()+ "/greet/Helidon"));
    }

    private static ServerConfiguration createConfiguration()
    {
        return  ServerConfiguration.builder()
                .port(8080)
                .build();
    }

    private static Routing createRouting()
    {
        return Routing.builder()
                .register(GreetService::new)
                .build();
    }
}
