package q6

class AccountList {
  
  var account: Account= null
  var pointer:  AccountList = null
    
  def createList() : AccountList = {
    var node = new AccountList
    return node
  }
  
  def insertElement(lst:AccountList, elm:Account) : AccountList = {
    var node = lst
    var newElement:AccountList = new AccountList

    if(lst.pointer==null){ 
    
      newElement.account = elm
      newElement.pointer = lst.pointer
      lst.pointer = newElement
      println("Nó adicionado com sucesso")
      return lst
       
    }
    
    while(node.pointer!=null){
      if(node.pointer.account.number<elm.number){
        newElement.account = elm
        newElement.pointer=node.pointer
        node.pointer = newElement
        return lst
        println("test")
      }
      
      node = node.pointer
    }
    newElement.account = elm
    newElement.pointer = lst.pointer
    lst.pointer = newElement
    println("nó adicionado com sucesso")
    return lst
    
        
  }
  
  def printRecursive (lst : AccountList) : AccountList = { 
    
    
    if(lst.pointer!=null){
      println(lst.pointer.account.number)
      return printRecursive(lst.pointer)
      
    }
    
    return lst
 
  }
  
  def printReverse (lst: AccountList) :AccountList = {
   
    if(lst.pointer!=null){
      
      printReverse(lst.pointer)
     
      println(lst.pointer.account.number)
    }
    //println(lst.ponteiro.info)

    return lst
    
  }
    
  def getElement(lst : AccountList, elm : Account) : Account={
   
    var aux = lst.pointer
    while(aux!=null){
      if(aux.account.number==elm.number){
        return aux.account
      }
      aux=aux.pointer
    }
    println("Element not found")
    return null
  }
  
  def removeElement(lst: AccountList, elm: Account): AccountList = {
    var aux = lst.pointer
    var aux2 = lst
    var lstFinal = lst
    
    //First element on the list
    if(lst.pointer.account.number==elm.number){
      lstFinal=aux.pointer
    }
    
    while(aux!=null){
      if(aux.account.number==elm.number){
        aux2.pointer=aux.pointer
        
      }
      aux2=aux
      aux=aux.pointer
      
    }
    println("Element not found")
    
    return lst
  }
  
  
      var lstTemp : AccountList =null
      def removeRecursive(lst: AccountList, elm: Account): AccountList = {
      
      lstTemp = lst
      //lstFinal=lst
    
      if(lstTemp.pointer==null){
        println("Não encontrado")
        return lst
      }
    
      if(lstTemp.pointer.account.number==elm.number){
        //auxRecursivo2 = auxRecursivo1.ponteiro
        //auxRecursivo1.ponteiro=auxRecursivo2.ponteiro
        lstTemp.pointer = lstTemp.pointer.pointer
        return lst
      }
      removeRecursive(lstTemp.pointer,elm)
    
      //println("não encontrado")
      return lst
 
  }
  
   def printList(lst : AccountList) : Unit = {
    
    var aux = lst.pointer
    
    //println(lst.info)
    while(aux!=null){
      
      println("Numero da conta")
      println(aux.account.number)
      println("")
      println("Saldo da conta")
      println(aux.account.amount)
      aux = aux.pointer
            
    }
    
  }
  
  def hasElement(lst:AccountList) : Int = {
    var aux : AccountList = lst 
    if(aux.pointer!=null){
      return 1
    }
    return 0
  }
  
  def freeList(lst : AccountList) : AccountList = {
    lst.pointer=null
    return lst
  }
  
  def isEqual(lst : AccountList) : Boolean = {
    while(this.pointer!=null){
      if(this.pointer.account.number!=lst.pointer.account.number){
        println("diferente")
        return false
      }
      this.pointer = pointer.pointer
    }
    
    println("igual")
    return true
  }
  
}