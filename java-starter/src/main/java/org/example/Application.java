package org.example;

import io.nitric.Nitric;

public class Application {
    public static void main(String[] args) {
        var api = Nitric.INSTANCE.api("api");

        api.get("/hello/:name", (ctx) -> {
            var name = ctx.getReq().getParams().get("name");

            ctx.getResp().text("hello " + name);

            return ctx;
        });

        Nitric.INSTANCE.run();
    }
}