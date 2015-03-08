#The Same App 5 Times

Writing a Link shortener in several different languages.

The Languages:
- Python
- Java
- Clojure
- Scala
- JavaScript

The Requirements:
- Unit Testing
- Redis Backend

This is a description of my experience doing so.

*language itself, libraries, testing, time required, deploying*

##Clojure

I've always wanted to learn a lisp and I've been playing around with learning them for some time. I played with Scheme, Common Lisp, but never really dug deeply into it. So I decided to write a link shortener - it's a pretty well scoped problem, I'll be able to reuse a lot of assets from across different projects - it's just overall a good choice.

There aren't a lot of resources on the web that teach you how to write clojure. Maybe a better way of putting it is google "link shortener python" then google "link shortener clojure". They exist for the latter, but not in the prevalence of the former. I didn't follow a tutorial for this although I did use [the clojure-docs](http://clojure-doc.org/articles/tutorials/basic_web_development.html) as a rough guide.

There were a couple of things that blew me away about Clojure. Firstly it felt extremely natural, all functions are nice and short and the naming conventions provided by polish-notation are a joy. The regex wasn't too bad (although I had to jump into some javadocs to understand limitations/capabilities) either. I'm also really intrigued by immutable data structures - this seems like a really good thing to me as it really forces you to make better design decisions.


####Libraries
[Carmine](https://github.com/ptaoussanis/carmine)
- Redis Helper
[Ring Clojure](https://github.com/ring-clojure)
I did 