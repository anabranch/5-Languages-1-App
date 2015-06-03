package com.billchambers.app

//Class based version, not using this one
class Url (inputUrl:String) {
  val validUrl ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".r;
  val url = inputUrl match {
    case validUrl(_*) => inputUrl
    case _ => ""
  }
}
//Object based version, like this one because it's more simple than the other
object validateUrl {
  val validUrl ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]".r;
  def apply(inputUrl:String): Boolean = {
    inputUrl match {
      case validUrl(_*) => true
      case _ => false
    }
  }
}
