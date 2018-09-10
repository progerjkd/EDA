class List extends ListTrait{
  var info = 0
  var ponteiro : List  =null 

  
  def createList():List = {
     
    var inicial : List = new List
    
    return inicial
    
    
  }
  
  def insertElement(lst:List, elm:Int) : List = {
    
    var node : List = new List 
    
    node.info = elm
    node.ponteiro = lst.ponteiro
    lst.ponteiro = node
    //lst.ponteiro=node
    //println("Nó adicionado com sucesso")
    return lst
       
  }
  
  def printList(lst : List) : Unit = {
    
    var aux = lst.ponteiro
    
    while(aux!=null){
      
      println(aux.info)
      aux = aux.ponteiro
            
    }
    
  }
  
  def printRecursive (lst : List) : List = { 
    
    
    if(lst.ponteiro!=null){
      println(lst.ponteiro.info)
      return printRecursive(lst.ponteiro)
      
    }
    
    return lst
 
  }
  
  def printReverse (lst: List) :List = {
   
    if(lst.ponteiro!=null){
      
      printReverse(lst.ponteiro)
     
      println(lst.ponteiro.info)
    }

    return lst
    
  }
  
  def hasElement(lst:List) : Int = {
    var aux : List = lst 
    if(aux.ponteiro!=null){
      return 1
    }
    return 0
  }
  
  def getElement(lst : List, elm : Int) : List={
   
    if(lst == null){
      println("Element not found")
      return null
    }
    var aux = lst.ponteiro
    while(aux!=null){
      if(aux.info==elm){
        return aux
      }
      aux=aux.ponteiro
    }
    println("Element not found")
    return null
  }
  
  def removeElement(lst: List, elm: Int): List = {
    var aux = lst.ponteiro
    var aux2 = lst
    var lstFinal = lst
    
    if(lst.ponteiro.info==elm){
      lstFinal=aux.ponteiro
    }
    
    while(aux!=null){
      if(aux.info==elm){
        aux2.ponteiro=aux.ponteiro
        
      }
      aux2=aux
      aux=aux.ponteiro
      
    }
    println("Element not found")
    
    return lst
  }
    
  var lstTemp : List =null
  def removeRecursive(lst: List, elm: Int): List = {
      
    lstTemp = lst
    
    if(lstTemp.ponteiro==null){
      println("Não encontrado")
      return lst
    }
    
    if(lstTemp.ponteiro.info==elm){
      lstTemp.ponteiro = lstTemp.ponteiro.ponteiro
      return lst
    }
    removeRecursive(lstTemp.ponteiro,elm)
    
    return lst
 
  }
  
  def freeList(lst : List) : List = {
    lst.ponteiro=null
    return lst
  }
  
}