package com.foriba.service;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class GreetService implements Service {

    private static String message = "Hello";

    @Override
    public void update(Routing.Rules rules)
    {
        rules.any("/",(req, res) -> res.send("Greeting from Helidon!"))
                .get("/greet/{name}", (req, res) -> res.send(message + " " + req.path().param("name")))
                .post("/greet/settings/{message}", GreetService::changeMessage);
    }


    private static void changeMessage(ServerRequest req, ServerResponse res)
    {
        String msg = req.path().param("message");
        message = msg;
        res.send("Message changed successfully");
    }
}
