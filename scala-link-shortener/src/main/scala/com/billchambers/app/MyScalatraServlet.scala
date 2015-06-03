package com.billchambers.app

import org.scalatra._
import scalate.ScalateSupport

class Routers extends MyScalaLinkShortenerStack {

  get("/") {
    contentType = "text/html"
    layoutTemplate("index", "title" -> "Hello This Title", "headline" -> "There", "body" -> "FINALLY")
  }

  get("/:link") {
    val templatePath = params("link")
    println(templatePath)

    findTemplate(templatePath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

  post("/"){

  }
}
