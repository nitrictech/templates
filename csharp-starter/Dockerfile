FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build

WORKDIR /app

# Copy everything
COPY . ./

# Build and publish a release
RUN dotnet publish -c Release -o out --self-contained --runtime linux-musl-arm64 -p:PublishSingleFile=true -p:PublishTrimmed=true

# Build runtime image
FROM mcr.microsoft.com/dotnet/runtime-deps:7.0

COPY --from=build /app/out/hello /usr/bin/handler

ENTRYPOINT ["handler"]