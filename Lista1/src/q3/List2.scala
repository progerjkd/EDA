package q3

class List2 {

  var head: Node2 = null
  
  def createList(): List2 = {
    var list: List2 = new List2
    return list
  }
  
  def freeList(lst: List2): List2 = {
    lst.head = null
    
    return lst
  }

  def insertList(head: Node2, info: Int): Node2 = {
    var node: Node2 = new Node2
    
    node.info = info
    node.next = head
    node.prev = null
    
    if (head != null) head.prev = node
    return node
  }
  
  def insertOrderedList(head: Node2, info: Int): Node2 = {
    var node, prev: Node2 = null
    var tmp = head
    
    while (tmp != null && tmp.info < info){
      prev = tmp
      tmp = tmp.next
    }
    
    node = new Node2
    node.info = info
    
    if(prev == null){  //inserts element in the beginning
      node.next = head
      node.prev = null
      return(node)
    }
    else {
      node.next = prev.next
      node.prev = prev
    //  prev.next.prev = node
      prev.next = node
      
      return(head)
    }    
 }
  
   def isEmptyList(node: Node2): Boolean ={
    return (node == null)
  }
  
   def printList(node: Node2): Unit = {
    var tmp: Node2 = node
    
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

  def printRecList(node: Node2, count: Int*): Unit = {
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
  
  
  def printRecInverseList(node: Node2, count: Int*): Unit = {
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
    
  def getElementList(node: Node2, key: Int): Int = {
    var tmp = node
    
    while(tmp != null){
      if(tmp.info == key) return tmp.info
      tmp = tmp.next
    }
    return(-999)
  }
  
  def searchList(node: Node2, key: Int): Node2 = {
    var tmp = node
    
    while(tmp != null){
      if(tmp.info == key) return tmp
      tmp = tmp.next
    }
    return null
  }
  
  def removeList(node: Node2, key: Int): Node2 = {
    var n = node
    var tmp = searchList(n, key)
  
    if(tmp == null)
      return node
    
    if(n == tmp)
      n = tmp.next
    else
      tmp.prev.next = tmp.next
      
    if(tmp.next != null)
      tmp.next.prev = tmp.prev
      
    return(n)
  }
  
  def removeRecList(node: Node2, key: Int): Node2 = {
    var tmp = node
    
    if(tmp.next == null) return node  // not found
    
    if(tmp.next.info == key){
      if(tmp.next.next == null){
        tmp.next = null
        return node
      }
      
      tmp.next = tmp.next.next
      tmp.next.next.prev = tmp
      
      return node
    }
    
    removeRecList(tmp.next, key)
    
    return node
  }
  
  def isEqual(head: Node2): Boolean = {
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