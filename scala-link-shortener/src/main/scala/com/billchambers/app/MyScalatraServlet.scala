package com.billchambers.app

import org.scalatra._
import scalate.ScalateSupport

class Routers extends MyScalaLinkShortenerStack {

  get("/") {
    contentType = "text/html"
    layoutTemplate("index", "genForm" -> true)
  }

  get("/:link") {
    val templatePath = params("link")
    findTemplate(templatePath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

  post("/"){

  }
}
