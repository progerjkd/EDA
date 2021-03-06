import q3._

object Questao3 {
  
 def main(args: Array[String]): Unit = {
   println("Beginning...")
   
//   var lst: List = new List
   var lst: List2 = new List2

   lst = lst.createList() // 3.1
    
   
   lst.head = lst.insertList(lst.head, 3)  // 3.2
   lst.head = lst.insertList(lst.head, 15)
   lst.head = lst.insertList(lst.head, 25)
   lst.head = lst.insertList(lst.head, 91)
   lst.head = lst.insertList(lst.head, 14)
   lst.head = lst.insertList(lst.head, 7)

   lst.printList(lst.head)  // 3.3
   lst.printRecList(lst.head) // 3.4
   
   lst.printRecInverseList(lst.head) // 3.5
   println("Is list empty? " + lst.isEmptyList(lst.head)) // 3.6

   val tmpNode: Node2 = lst.searchList(lst.head, 14) // 3.7

   if(tmpNode != null)
     println("Key found: " + tmpNode.info)
   else
     println("Key not found!")
     
   lst.printList(lst.head)
   println("Removing element 91...")
   lst.head = lst.removeList(lst.head, 91) // 3.8
   lst.printList(lst.head)
   
   println("Recursively removing element 14...")
   lst.head = lst.removeRecList(lst.head, 14) // 3.9
   lst.printList(lst.head)
   
   
   println("Releasing list...")
   lst.freeList(lst) // 3.10
   lst.printList(lst.head)

   
   println("Creating a new doubly linked list...")

   lst = lst.createList() 
   
   lst.head = lst.insertOrderedList(lst.head, 3)  
   lst.head = lst.insertOrderedList(lst.head, 15)
   lst.head = lst.insertOrderedList(lst.head, 25)
   lst.head = lst.insertOrderedList(lst.head, 91)
   lst.head = lst.insertOrderedList(lst.head, 14)
   lst.head = lst.insertOrderedList(lst.head, 7)
   
   println("Creating auxiliary list...")
   var aux: List2 = new List2
   aux = aux.createList()
    
   aux.head = aux.insertOrderedList(aux.head, 3)
   aux.head = aux.insertOrderedList(aux.head, 15)
   aux.head = aux.insertOrderedList(aux.head, 25)
   aux.head = aux.insertOrderedList(aux.head, 91)
   aux.head = aux.insertOrderedList(aux.head, 14)
   aux.head = aux.insertOrderedList(aux.head, 7)
   
   print("aux: ")
   aux.printList(aux.head)
   print("lst: ")
   lst.printList(lst.head)
   
   println("Are the doubly linked lists 'lst' and 'aux' equals? " + lst.isEqual(aux.head))  // 3.11

   
 }
}