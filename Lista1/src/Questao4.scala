import q4._

object Questao4 {
  def main(args: Array[String]): Unit = {
    println("Beginning...")
    
    var lst: RoundList = new RoundList

    lst = lst.createList() // 4.1
   
    lst.head = lst.insertList(lst.head, 10) // 4.2
    lst.head = lst.insertList(lst.head, 7)
    lst.head = lst.insertList(lst.head, 32)
    lst.head = lst.insertList(lst.head, 21)
    lst.head = lst.insertList(lst.head, 53)
    lst.head = lst.insertList(lst.head, 9)
    lst.head = lst.insertList(lst.head, 25)
   
    lst.printList(lst.head)  // 4.3
    lst.printRecList(lst.head) // 4.4
   
    println("\nIs list empty? " + lst.isEmptyList(lst.head)) // 4.5
    val tmpNode: NodeR = lst.searchList(lst.head, 53) // 4.6

    if(tmpNode != null)
      println("Key found: " + tmpNode.info)
    else
      println("Key not found!")
      
    lst.printList(lst.head)
    println("Removing element 9...")
    lst.head = lst.removeList(lst.head, 9) // 4.7
    lst.printList(lst.head)
    
    println("Recursively removing element 32...")
    lst.head = lst.removeRecList(lst.head, 32) // 4.8
    lst.printList(lst.head)

   println("Releasing list...")
   lst.freeList(lst) // 4.9
   lst.printList(lst.head)

    
 }
}