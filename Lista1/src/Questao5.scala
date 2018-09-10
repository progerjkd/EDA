import q5._

object Questao5 {
  def main(args: Array[String]): Unit = {
   println("Beginning...")
    
   var lst: RoundList2 = new RoundList2

   lst = lst.createList() // 5.1
   lst.head = lst.insertList(lst.head, 10) // 5.2
   lst.head = lst.insertList(lst.head, 7)
   lst.head = lst.insertList(lst.head, 32)
   lst.head = lst.insertList(lst.head, 21)
   lst.head = lst.insertList(lst.head, 53)
   lst.head = lst.insertList(lst.head, 9)
   lst.head = lst.insertList(lst.head, 25)
   println("Size: " + lst.listSize(lst))

   
   lst.printList(lst.head)  // 5.3
   lst.printRecList(lst.head) // 5.4
   
   println("\nIs list empty? " + lst.isEmptyList(lst.head)) // 5.5
   val tmpNode: NodeR2 = lst.searchList(lst.head, 252) // 5.6

   if(tmpNode != null)
     println("Key found: " + tmpNode.info)
   else
     println("Key not found!")
      
   lst.printList(lst.head)
   println("Removing element 21...")
   lst.head = lst.removeList(lst.head, 10) // 5.7
   lst.printList(lst.head)

   println("Recursively removing element 25...")
   lst.removeRecList3(lst.head, 25) // 5.8
   lst.printList(lst.head)
   
   println("Releasing list...")
   lst.freeList(lst) // 5.9
   lst.printList(lst.head)


 }
}