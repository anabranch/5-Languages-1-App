#Scala

Well things are certainly a bit different in Scala. I decided to use Scalatra. It seems relatively straightforward but dealing with the actor paradigm is certainly a departure from what I'm used to. The first concept I really had to wrestle with was that of a Servlet and Servlet Context. A servlet is simply a way of running a webserver and responding to requests, which are in this case HTTP requests. It's a bit like middleware between the actual receiving of a request and what actually happens with it. The context is like the global context in which that service exists.

