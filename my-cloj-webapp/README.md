# my-cloj-webapp

A Simple URL Shortener in Clojure.

Docker Linking is done with:

`https://docs.docker.com/userguide/dockerlinks/`

## Prerequisites

You will need [Leiningen](https://github.com/technomancy/leiningen) 2.0.0 or above installed.
You will need to have a [redis](http://redis.io/) server running.

## Running

To start a web server for the application, run:

    lein ring server

## Tests

```clojure
lein test
```

## Build & Deploy with Docker

```sh
make image
```

```sh
# Run Redis
docker run --name new-red -d redis

#Run
docker run --name clj --link new-red:new-red -p 5000:5000 -d my-cloj
```

## License

Copyright © 2015 Bill Chambers
