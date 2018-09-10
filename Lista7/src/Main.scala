

object Main {
  
  def main( args : Array[String]){
    
    var disjointSet = new DisjointSet()
    disjointSet.createSet(10)    // 7.1
    
    for(i<-0 until 10) { 
      var node = new Node
      node.info=i
      disjointSet.nodes(i) = node
      
    }
    
    disjointSet.makeSet()
    disjointSet.union(5, 3)    // 7.2
    
    println(disjointSet.getRep(3))  // 7.3
    println(disjointSet.isSameSet(5, 3))  // 7.4
    println(disjointSet.isSameSet(5, 4))
    
    disjointSet.release()  // 7.5
    
  }
}