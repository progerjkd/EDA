import q1._
import q2._

object Questao1 {
  
 def main(args: Array[String]): Unit = {
   println("Beginning...")
   
   var lst: List = new List

   lst = lst.createList() // 1.1
   
   lst.head = lst.insertList(lst.head, 10) // 1.2
   lst.head = lst.insertList(lst.head, 20)
   lst.head = lst.insertList(lst.head, 30)
   lst.head = lst.insertList(lst.head, 40)
   lst.head = lst.insertList(lst.head, 50)
   lst.head = lst.insertList(lst.head, 60)
   lst.head = lst.insertList(lst.head, 70)
   
   lst.printList(lst.head)  // 1.3
   lst.printRecList(lst.head) // 1.4
   
   lst.printRecInverseList(lst.head) // 1.5
   println("Is list empty? " + lst.isEmptyList(lst.head)) // 1.6

   val tmpNode: Node = lst.searchList(lst.head, 20) // 1.7

   if(tmpNode != null)
     println("Key found: " + tmpNode.info)
   else
     println("Key not found!")
     
   lst.printList(lst.head)
   println("Removing element 50...")
   lst.head = lst.removeList(lst.head, 50) // 1.8
   lst.printList(lst.head)

   println("Recursively removing element 20...")
   lst.head = lst.removeRecList(lst.head, 20) // 1.9
   lst.printList(lst.head)
   
   
   println("Releasing list...")
   lst.freeList(lst) // 1.10
   lst.printList(lst.head)

   
     
 }
}
 
   
  
  
