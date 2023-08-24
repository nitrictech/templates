import io.nitric.Nitric

fun main() {
    val api = Nitric.api("api")

    api.get("/hello/:name") { ctx ->
        val name = ctx.req.params["name"]

        ctx.resp.text("hello $name")

        ctx
    }
    Nitric.run()
}