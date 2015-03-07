# my-cloj-webapp

A Simple URL Shortener in Clojure.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen
[Redis]: It uses redis to store the shortened urls.

## Running

To start a web server for the application, run:

    lein ring server

## Tests

```clojure
lein test
```

## License

Copyright © 2015 Bill Chambers
