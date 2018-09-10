package q2
import q1.Node

class OrderedList{
  
  var head: Node = null
  
//  var info: Int = 0
//  var next: List = null


  def createList(): OrderedList = {
    var list: OrderedList = new OrderedList
    return list
  }
  
  def freeList(lst: OrderedList): OrderedList = {
    lst.head = null
    
    return lst
  }
  
  /*def insertList(lst: List, info: Int): Node = {
    var node: Node = new Node
    
    node.info = info
    node.next = lst.head
    return node
  }*/
  
  def insertList(head: Node, info: Int): Node = {
    var node: Node = new Node
    
    node.info = info
    node.next = head
    return node
  }  
  
  def isEmptyList(node: Node): Boolean ={
    return (node == null)
  }
     
  def printList(node: Node): Unit = {
    var tmp: Node = node
    
    if(tmp == null)
      print("Empty list")
    else
      print("|")
      
    while(tmp != null){
      print(tmp.info + "|")
      tmp = tmp.next
    }
    println("")
  }
  
  
  def printRecList(node: Node, count: Int*): Unit = {
    var tmp = node
  
  if (count.size == 0 && node != null)
      print("|")
      
     if(!isEmptyList(node)){
       print(node.info + "|")
       printRecList(node.next,1)
     }
    
     if (count.size == 0 && node != null)
       println("")
  }
  
  
  def printRecInverseList(node: Node, count: Int*): Unit = {
    var tmp = node
  
    if (count.size == 0 && node != null)
      print("|")
      
     if(node != null){
       printRecInverseList(node.next,1)
       print(node.info + "|")
     }
    
     if (count.size == 0 && node != null)
       println("")
  }
    
  def getElementList(node: Node, key: Int): Int = {
    var tmp = node
    
    while(tmp != null){
      if(tmp.info == key) return tmp.info
      tmp = tmp.next
    }
    return(-999)
  }
  
  def searchList(node: Node, key: Int): Node = {
    var tmp = node
    
    while(tmp != null){
      if(tmp.info == key) return tmp
      tmp = tmp.next
    }
    return null
  }
  
  def removeList(node: Node, key: Int): Node = {
    var prev: Node = null
    var tmp = node

    while(tmp != null && tmp.info != key){
      prev = tmp
      tmp = tmp.next
    }
    
    if(tmp == null)       // não achou: retorna lista original
      return(node)
      
    if(prev == null)    // retira elemento do início
      return(tmp.next)
    else {               // retira elemento do meio da lista
      prev.next = tmp.next
    }
    
    return node
  }

  def removeRecList(node: Node, key: Int): Node = {
    var tmp = node 
    
    if(node != null){
      if(node.info == key){
        tmp = node.next
      }
      else {
        tmp.next = removeRecList(tmp.next, key)
      }
    }
    
    return tmp
  }
  
  def insertOrderedList(head: Node, info: Int): Node = {
    var node, prev: Node = null
    var tmp = head
    
    while (tmp != null && tmp.info < info){
      prev = tmp
      tmp = tmp.next
    }
    
    node = new Node
    node.info = info
    
    if(prev == null){  //inserts element in the beginning
      node.next = head
      return(node)
    }
    else {
      node.next = prev.next
      prev.next = node
      return(head)
    }    
 }
 
  def isEqual(head: Node): Boolean = {
    var tmp1 = this.head
    var tmp2 = head
    
    while(tmp1 != null && tmp2 != null){
      if(tmp1.info != tmp2.info) return false
      tmp1 = tmp1.next
      tmp2 = tmp2.next
    }
    return (tmp1 == tmp2)
  }
  
}