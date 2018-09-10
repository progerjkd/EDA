package q6

class Account {
  var number : Int = 0
  var amount : Double = 0
  
  def credit(value : Double) : Unit ={
     if(value > 0){
       amount = amount + value
     }
  }
  
  def debit(value : Double) : Unit ={
     if(value > 0){
       amount = amount - value
     }
  }
  
}