import { api } from "@nitric/sdk";

const helloApi = api('main');

helloApi.get("/hello/:name", async (ctx) => {
    const { name } = ctx.req.params;

    ctx.res.body = `Bye ${name}`;

    return ctx;
});