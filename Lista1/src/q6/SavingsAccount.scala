package q6

class SavingsAccount extends Account {
  def addInterest() : Unit =  {
    amount = amount * 1.07
  }
}