from nitric.resources import Api

helloApi = Api("main")


@helloApi.get("/hello/:name")
async def hello_world(ctx):
    name = ctx.req.params.name

    ctx.res.body = f"Hello {name}"
    return ctx
