package com.billchambers.app

import org.scalatra._
import scalate.ScalateSupport

class Routers extends MyScalaLinkShortenerStack {

  get("/") {
    contentType = "text/html"
    layoutTemplate("index")
  }

  get("/:link") {
    val templatePath = params("link")
    findTemplate(templatePath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

  post("/"){
    val link = params("link")
    val outputTemplate = layoutTemplate("link", _:(String,Any), _:(String,String))
    contentType = "text/html"
    LinkController.setLink(link) match {
      case hashed: String => outputTemplate("link" -> hashed, "oldLink" -> link)
      // case bool: Boolean => outputTemplate("displayForm" -> true // unnecessary
      case _ => outputTemplate("displayForm" -> true, "oldLink" -> link)
    }
  }
}
