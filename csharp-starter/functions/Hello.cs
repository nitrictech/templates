using Nitric.Sdk;
using System;

var serviceAddress = System.Environment.GetEnvironmentVariable("SERVICE_ADDRESS");

Console.WriteLine(serviceAddress);

var api = Nitric.Sdk.Nitric.Api("main");

api.Get("/hello/:name", context =>
{
    var name = context.Req.PathParams["name"];

    context.Res.Text($"Hello {name}!");

    return context;
});

Nitric.Sdk.Nitric.Run();