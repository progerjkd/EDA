class Hash {
  
  def doHash1(str: String): Int = {
    var tmp: Int = 0
    str.foreach(x => tmp += x.toInt)
  
    return tmp % 513
  }

}