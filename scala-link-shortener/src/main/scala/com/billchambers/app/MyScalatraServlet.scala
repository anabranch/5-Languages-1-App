package com.billchambers.app
import org.scalatra._
import scalate.ScalateSupport

class Routers extends MyScalaLinkShortenerStack {
  get("/") {
    contentType = "text/html"
    layoutTemplate("index")
  }

  get("/:link") {
    val link = params("link")
    contentType = "text/html"
    val x:String = LinkController.getLink("sdfsd")
    LinkController.getLink(link.toString) match {
      case str:String => redirect(str)
      case null => serveStaticResource() getOrElse resourceNotFound()
    }
    layoutTemplate("index")
  }

  post("/"){
    val link = params("link")
    val outputTemplate = layoutTemplate("link", _:(String,Any), _:(String,String))
    contentType = "text/html"
    LinkController.setLink(link) match {
      case hashed: String => outputTemplate("link" -> hashed, "oldLink" -> link)
      case _ => outputTemplate("displayForm" -> true, "oldLink" -> link)
    }
  }
}
