class Hash extends HashTrait {
  
  var size : Int = 0
  
  var table : Array[List] = null
  
  def create( n: Int) : Unit = {
    size = n/2
    table = new Array[List](size) 
  }
  
  def hash(n : Int) : Int = {
    return n%size
  }
  
  def insert( elm : Int): Unit = {
   var aux : List = new List()
   var index : Int = hash(elm)
   
   aux.info=elm
   if(table(index)==null){
     table(index) = aux       
   }
   
   table(index).insertElement(table(index), elm)
   
   
  }
  
  def search( elm : Int) : Int = {
    var aux : List = new List()
    var index : Int = hash(elm)
    aux = table(index)
    if(aux!=null){
      aux= aux.getElement(aux, elm)
      return aux.info
    }
    println("Not found!" )
    return -999
    
  }
  
  def remove(elm : Int) : Unit = {
    
    var index : Int = hash(elm)
    table(index) = null
      
  }
  
  def release() : Unit = {
    table = null
  }

}