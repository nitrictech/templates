from nitric.resources import api
from nitric.application import Nitric
from nitric.faas import HttpContext

helloApi = api("main")


@helloApi.get("/hello/:name")
async def hello_world(ctx: HttpContext):
    name = ctx.req.params['name']

    ctx.res.body = f"Hello {name}"

Nitric.run()