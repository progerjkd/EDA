

class DisjointSet extends DisjointSetTrait {
  
  var nodes : Array[Node]=null
  
  def createSet(size : Int) = {    // 7.1
    nodes = new Array[Node](size)
    for(i<-0 until nodes.length) nodes(i)= new Node
  }

  def getRep(elm: Int) : Int= {
    for(i<-0 until nodes.length){
      if (nodes(i).info == elm){
        return nodes(i).rep
      }
      
    }
    return -2
  }
  
  def makeSet()={
    for(i<-0 until nodes.length) nodes(i).rep = nodes(i).info
      
  }
  
  def union(elm1 : Int, elm2:Int) = {
    var rep1 = getRep(elm1)
    for ( i <-0 until nodes.length){
      if (nodes(i).rep==elm2) nodes(i).rep=rep1
    }
  }
  
  def isSameSet(elm1: Int, elm2:Int) = getRep(elm1)==getRep(elm2) 

  def release() = nodes = null
 
  
}