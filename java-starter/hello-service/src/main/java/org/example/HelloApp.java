package org.example;

import io.nitric.Nitric;

public class HelloApp {
    public static void main(String[] args) {
        var app = Apis.publicApi();

        app.get("/goodbye/:name", (ctx) -> {
            var name = ctx.getReq().getParams().getOrDefault("name", "world");

            ctx.getResp().text(String.format("Goodbye %s!", name));

            return ctx;
        });

        Nitric.INSTANCE.run();
    }
}