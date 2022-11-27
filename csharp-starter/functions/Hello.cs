using Nitric.Sdk;

var api = Nitric.Sdk.Nitric.Api("main");

api.Get("/hello/:name", context =>
{
    var name = context.Req.PathParams["name"];

    context.Res.Text($"Hello {name}!");

    return context;
});

Nitric.Sdk.Nitric.Run();