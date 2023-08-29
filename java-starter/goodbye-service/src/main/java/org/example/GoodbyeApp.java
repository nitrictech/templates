package org.example;

import io.nitric.Nitric;

public class GoodbyeApp {
    public static void main(String[] args) {
        var app = Apis.publicApi();

        app.get("/hello/:name", (ctx) -> {
           var name = ctx.getReq().getParams().getOrDefault("name", "world");

           ctx.getResp().text(String.format("Hello %s!", name));

           return ctx;
        });

        Nitric.INSTANCE.run();
    }
}