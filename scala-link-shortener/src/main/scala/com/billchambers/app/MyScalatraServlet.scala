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
    <html>
    <body>
    <h1>{params("link")}</h1>
      </body>
    </html>
  }

  post("/"){

  }
}
