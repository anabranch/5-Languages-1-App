package com.billchambers.app
import scala.util.hashing.MurmurHash3
import com.redis._

object RedisWrapper {
  val redis = new RedisClient("localhost", 6379)
}

//Object based version, like this one because it's more simple than the other
object validateUrl {
  def apply(inputUrl:String): Any = {
    val validUrl = "^(https?|ftp|file)://.[a-zA-Z]{1,3}[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]*?".r
        inputUrl match {
          case validUrl(_*) => true
          case _ => false
        }
  }
}

object LinkController{
  def getLink(shortenedLink:String): String = {
      RedisWrapper.redis.get(shortenedLink).orNull
  }
  def setLink(inputLink:String): Any = {
    val hashedLink = MurmurHash3.stringHash(inputLink).toString
    if (validateUrl(inputLink) == true){
      val x = RedisWrapper.redis.set(hashedLink, inputLink)
      hashedLink
    }
    else {
       false
    }
  }
}

