package q4

class RoundList {
  var head: NodeR = null

  def createList(): RoundList = {
    var list: RoundList = new RoundList
    list.head = new NodeR
    list.head.isHead = true
    list.head.next = list.head
    
    return list
  }
  
  def freeList(lst: RoundList): RoundList = {
    lst.head.isHead = true
    lst.head.next = lst.head
    
    return lst
  }
  
  def insertList(head: NodeR, info: Int): NodeR = {
    var node: NodeR = new NodeR
    
    node.info = info
    node.next = head
    return node
  }
  
  def isEmptyList(node: NodeR): Boolean ={
    return (node.isHead == true && node.next == node)
  }
  
  def printList(node: NodeR): Unit = { 
    var tmp: NodeR = node
    
    if(tmp.isHead == true && tmp.next == tmp)
      print("Empty list")
    else
      print("|")
      
    while(tmp.isHead == false){
      print(tmp.info + "|")
      tmp = tmp.next
    }
    println("")
  }
  def printRecList(node: NodeR, count: Int*): Unit = { 
    if (count.size == 0 && node != null)
      print("|")
      
    if(node.isHead == false){
      print(node.info + "|")
      return printRecList(node.next, 1)
    }
    
    if (count.size == 0 && node != null)
       println("")
  }
  
  def searchList(node: NodeR, key: Int): NodeR = {
    var tmp = node
    
    while(tmp.isHead == false){
      if(tmp.info == key) return tmp
      tmp = tmp.next
    }
    return null
  }
  
  def removeList(node: NodeR, key: Int): NodeR = {
    var prev: NodeR = null
    var tmp = node

    while(tmp.isHead == false && tmp.info != key){
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

  def removeRecList(node: NodeR, key: Int): NodeR = {
    var tmp = node
    
    if(node.isHead == false){
      if(node.info == key){
        tmp = node.next
      }
      else {
        tmp.next = removeRecList(tmp.next, key)
      }
    }
    
    return tmp
  } 


  
}