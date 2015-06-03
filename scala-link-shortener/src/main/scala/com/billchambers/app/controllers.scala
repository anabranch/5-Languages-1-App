package com.billchambers.app

class Url (inputUrl:String) {
  val validUrl ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".r;
  val url = inputUrl match {
    case validUrl(_*) => inputUrl
    case _ => ""
  }
}

object ValidateUrl {
  val validUrl ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".r;
  def apply(inputUrl:String): Boolean = {
    inputUrl match {
      case validUrl(_*) => true
      case _ => false
    }
  }
}

