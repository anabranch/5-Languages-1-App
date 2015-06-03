package com.billchambers.app

import org.scalatra.test.specs2._
import org.specs2._

class ValidateSpec extends Specification { def is = s2"""

this is the specification for Url Validation
  where http://www.google.com must be true   $e1
  where not must be false   $e2
"""
  def e1 = validateUrl("http://www.google.com") must_== true
  def e2 = validateUrl("not") must_== false
}


class LinkControllerSpec extends Specification { def is = s2"""

this is the specification for the Link Controller
  where setLink with http://www.google.com will return -1524223440    $e1
  where getLink with -1524223440 will return http://www.google.com    $e2
  where setLink with "not" work will return false     $e3
"""
  def e1 = LinkController.setLink("http://www.google.com") must_== "-1524223440"
  def e2 = LinkController.getLink("-1524223440") must_== "http://www.google.com"
  def e3 = LinkController.setLink("not work") must_== false
}
