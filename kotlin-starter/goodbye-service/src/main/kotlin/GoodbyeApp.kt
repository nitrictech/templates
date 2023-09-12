import io.nitric.Nitric
import io.nitric.common.PublicApi

fun main() {
    val api = PublicApi()

    api.get("/goodbye/:name") { ctx ->
        val name = ctx.req.params["name"]

        ctx.resp.text("goodbye $name")

        ctx
    }

    Nitric.run()
}