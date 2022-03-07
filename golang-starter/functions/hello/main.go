// [START snippet]

package main

import (
	"github.com/nitrictech/go-sdk/faas"
	"github.com/nitrictech/go-sdk/resources"
)

func main() {
	mainApi := resources.NewApi("main")
	mainApi.Get("/hello/:name", func(ctx *faas.HttpContext, next faas.HttpHandler) (*faas.HttpContext, error) {
		params := ctx.Request.PathParams()
		if params == nil || len(params["name"]) == 0 {
			ctx.Response.Body = []byte("error retrieving path params")
			ctx.Response.Status = 400
		} else {
			ctx.Response.Body = []byte("Hello " + params["name"])
			ctx.Response.Status = 200
		}

		return next(ctx)
	})

	err := resources.Run()
	if err != nil {
		panic(err)
	}
}

// [END snippet]
