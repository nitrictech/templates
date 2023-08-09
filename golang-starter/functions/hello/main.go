package main

import (
	"fmt"

	"github.com/nitrictech/go-sdk/faas"
	"github.com/nitrictech/go-sdk/nitric"
)

func main() {
	mainApi, err := nitric.NewApi("main")
	if err != nil {
		fmt.Println(err)
		return
	}

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

	fmt.Println("running main API")
	if err := nitric.Run(); err != nil {
		fmt.Println(err)
	}
}
