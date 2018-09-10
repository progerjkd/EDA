package q6

class FidelityAccount extends Account{
  var bonus : Double = 0
  
  
  override def credit(value : Double): Unit ={
    bonus = bonus + 0.01*value
    amount = amount + value
  }
  def concederBonus(): Unit = {
    amount = amount + bonus
    bonus = 0
  }
  def consultarBonus(): Double = {
    return bonus 
  }
}