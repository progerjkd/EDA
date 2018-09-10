package q5

class RoundList2 {
  
  var head: NodeR2 = null

  def createList(): RoundList2 = {
    var list: RoundList2 = new RoundList2
    list.head = new NodeR2
    list.head.isHead = true
    list.head.next = list.head
    list.head.prev = list.head

    return list
  }
  
  def listSize(lst: RoundList2): Int = {
  
    var tmp = lst.head
    var size = 1
    
    while(tmp.next.isHead == false){
      size += 1
      tmp = tmp.next
    }
      
    
    return size
  }
  
  def freeList(lst: RoundList2): RoundList2 = {
    lst.head.isHead = true
    lst.head.next = lst.head
    lst.head.prev = lst.head
    lst.head.info = 0
    return lst
  }
  
  def findHead(node: NodeR2): NodeR2 = {
    var tmp = node
    while(tmp.isHead == false){
      tmp = tmp.next
    }
    return tmp
  }

  def insertList(node: NodeR2, info: Int): NodeR2 = {
    
    var tmp: NodeR2 = if (this.listSize(this) == 1 && this.head.info == 0) this.head else new NodeR2    
    var head = findHead(node)
//    println("insert size: " + this.listSize(this))
//    println("head value: " + head.info)
    
    tmp.info = info
    tmp.next = head
    tmp.prev = head.prev
    head.prev.next = tmp
    head.prev = tmp
    head.isHead = false
    tmp.isHead = true
    
    return tmp
  } 
  
  
  def insertList2(node: NodeR2, info: Int): NodeR2 = {
    var tmp: NodeR2 = new NodeR2
    var head = findHead(node)
    
    tmp.info = info
    tmp.next = head
    tmp.prev = head.prev
    head.prev.next = tmp
    head.prev = tmp
    head.isHead = false
    tmp.isHead = true
    
    return tmp
  } 
  
  def isEmptyList(node: NodeR2): Boolean ={
    return (node.isHead == true && node.next == node)
  }
  
  def printList(node: NodeR2): Unit = {
    
    var head = findHead(node)
    
     if(head.isHead == true && head.next == head && head.prev == head && head.info == 0)
      println("Empty list")
    else {
      print("|" + head.info + "|")
      head = head.next
    }
    
    while(head.isHead == false){
      print(head.info + "|")
      head = head.next
    }

    println("")    
    
  }
  
  def printRecList(node: NodeR2, count: Int*): Unit = {
    if (count.size == 0 && head != null)
      print("|")
    
    if (this.listSize(this) == 1){
      println(node.info + "|")
      return
    }
    else {
      if(node.next.isHead == false){
        print(node.info + "|")
        return printRecList(node.next, 1)
      }
    }
    if (node == head.prev){
      print(node.info + "|")
    }
    if (count.size == 1 && head != null){
      
      println("")
    }
  }
  
  def searchList(node: NodeR2, key: Int): NodeR2 = {
    var head = this.findHead(node)
    var tmp = node
    
    while(tmp.next.isHead == false){
      if(tmp.info == key) return tmp
      tmp = tmp.next
    }
    return null
  }
  
  def removeList(node: NodeR2, key: Int): NodeR2 = {
    var prev: NodeR2 = null
    var next: NodeR2 = null
    var head = findHead(node)
    var tmp = head

    while(tmp.next != head && tmp.info != key){
      prev = tmp
      tmp = tmp.next
    }
    
    if(tmp.next == head && tmp.info != key)       // não achou: retorna lista original
      return(node)
      
    if(prev == null && tmp.next == head && tmp.prev == head){ // lista contém apenas um elemento, que será removido. Retorna lista vazia
        head.isHead = true
        head.next = head
        head.prev = head
        head.info = 0
        return(head)
    }
      
    if(prev == null){    // retira elemento do início de uma lista com mais de um elemento
      head.prev.next = head.next
      head.next.prev = head.prev
      head.next.isHead = true
      return(head.next)
    }
    else {               // retira elemento do meio da lista
      prev.next = tmp.next
      tmp.next.prev = prev
      return(tmp)
    }
    
    
  }

  def removeRecList(node: NodeR2, key: Int): NodeR2 = {
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
  
  def removeRecList3(node: NodeR2, key: Int): Unit = {
    var tmp = node
    var tmp2: NodeR2 = null
    
    if(tmp.info == key){
      tmp.prev.next = tmp.next
      tmp.next.prev = tmp.prev
      if(tmp.isHead == true){
        tmp.isHead = false
        tmp.next.isHead = true
      }
     }
      else {
        removeRecList3(tmp.next, key)
      }
   }
    
  
  def removeRecList2(node: NodeR2, key: Int): NodeR2 = {
    
    
    if (this.listSize(this) == 1 && node.info == key ){
      node.info = 0
      node.next = node
      node.prev = node
      node.isHead = false
      return(node)
    }
    else {
      if(node.isHead == false){
        return(removeRecList2(node.next, key))
      }
    }
    return null
 }
   
}