package com.billchambers.app

import org.scalatra.test.specs2._

class MyScalatraServletSpec extends MutableScalatraSpec {
  addServlet(classOf[Routers], "/*")

  "Get / " should {
    "return 200" in {
      get("/") {
        status must_== 200
      }
    }
  }

  "Post to /" should {
    "create new value and return 200" in {
      post("/", Map("link" -> "http://www.google.com")) {
        status must_== 200
      }
    }
  }

  "Get /-1524223440" should {
    "get redirected to google's page and return 200, may fail if not after POST" in {
      get("/-1524223440") {
        status must_== 302
      }
    }
  }

}
