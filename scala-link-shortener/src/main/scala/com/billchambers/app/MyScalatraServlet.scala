package com.billchambers.app

import org.scalatra._
import scalate.ScalateSupport

class Router extends MyScalaLinkShortenerStack {

  get("/") {
    <html>
    <body>
    <h1>Hello, world!</h1>
    Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

  get("/:link") {
    val link = params("link")
    val templatePath = link
    println(templatePath)

    findTemplate(templatePath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

  post("/"){

  }
}
