#Scala

Well things are certainly a bit different in Scala. I decided to use Scalatra. It seems relatively straightforward but dealing with the actor paradigm is certainly a departure from what I'm used to. The first concept I really had to wrestle with was that of a Servlet and Servlet Context. A servlet is simply a way of running a webserver and responding to requests, which are in this case HTTP requests. It's a bit like middleware between the actual receiving of a request and what actually happens with it. The context is like the global context in which that servlet exists.

Once I got a hold of that I obviously needed to be sure that I understood a lot of the actual Scala nuances, like traits. Twitter's Scala School was pretty helpful for teaching the basics of the language. One thing about Scala is that there seems to be a lot of different ways of doing things. I could create a class that handle my url validation (basically creating a url class), or I could create a singleton object that would essentially be a function to do that for me.

Here's the classed based way, with pattern matching.

```scala
class Url (inputUrl:String) {
  val validUrl ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".r;
  val url = inputUrl match {
    case validUrl(_*) => inputUrl
    case _ => ""
  }
}
```
This was the singleton object based way with pattern matching as well.

```scala
object ValidateUrl {
  val validUrl ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".r;
  def apply(inputUrl:String): Boolean = {
    inputUrl match {
      case validUrl(_*) => true
      case _ => false
    }
  }
}
// use with ValidateUrl("http://www.google.com")
```

I tried running it as simply a function but I kept getting compilation errors with sbt. Not sure if that was something that I was doing or not but it was simple enough to throw it in an object and move on.

Unfortunately a fair amount of time in this project was figuring out the template engine. I actually found the clojure way of doing things much more intuitive as clojure seems to have a cleaner DSL with `hic-el` to generate html. Having to deal with jade templates and their nuances was non-productive pain in many ways.

