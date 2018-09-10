object Main {
  
  def main(args: Array[String]): Unit = {
    
    var heap = new MinHeap(255)
    
    heap.insert(45)
    heap.insert(24)
    heap.insert(13)
    heap.insert(6)
    heap.insert(85)
    heap.insert(23)
    heap.insert(64)
    heap.insert(93)
    heap.insert(62)
    heap.insert(81)
    heap.insert(18)
    heap.insert(150)
    
    println()
    
    heap.display()
    
    heap.search(85)
    heap.remove(62)
    heap.display()
    
    println("Updating elemento 93 to 22...\n")
    
    heap.updateValue(93, 22)
    
    heap.display()
       
  }
}