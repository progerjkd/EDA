
object MainProgram {
  
  def main(args: Array[String]): Unit = {
    
    var table = new Directory(150)  // 4.1

    table.createHashTable()
  
    table.insert(3)  // 4.2
    table.insert(234)
    table.insert(6)
    table.insert(88)
    table.insert(34)
    table.insert(25)
    table.insert(126)
    table.insert(99)
    table.insert(25)
    table.insert(24)
    table.insert(94)
    table.insert(63)
    table.insert(82)
    
    println()
    
    
    table.display()
    
    table.search(25)  // 4.3
    table.search(63)
    
    table.remove(234)  // 4.4
    table.remove(99)
    table.remove(96)
    table.remove(52)
    
    table.display()

   
  }
}