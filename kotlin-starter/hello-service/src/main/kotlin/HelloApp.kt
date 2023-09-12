import io.nitric.Nitric
import io.nitric.common.PublicApi

fun main() {
    val api = PublicApi()

    api.get("/hello/:name") { ctx ->
        val name = ctx.req.params["name"]

        ctx.resp.text("hello $name")

        ctx
    }

    Nitric.run()
}