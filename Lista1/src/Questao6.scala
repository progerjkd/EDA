import q6._    

object Questao6 {
  
def main(args: Array[String]): Unit = {
    
  var lstConta : AccountList = new AccountList
  
  lstConta = lstConta.createList()  // 6.1
    
   
  var conta, conta2, conta3 : Account = new Account  // 6.2
  conta.number=1
  conta.amount=200
  lstConta = lstConta.insertElement(lstConta,conta)
  conta2.number=2
  conta2.amount=400
  conta.number=3
  conta.amount=500
  lstConta = lstConta.insertElement(lstConta,conta)
  lstConta = lstConta.insertElement(lstConta,conta2)
  lstConta = lstConta.insertElement(lstConta,conta3)
     
  lstConta.printList(lstConta) // 6.3
    
  lstConta.printRecursive(lstConta)  // 6.4  
  
  lstConta.printReverse(lstConta)  // 6.5

  println(lstConta.hasElement(lstConta))
    
  var auxConta : Account = new Account  // 6.7
    
  auxConta = lstConta.getElement(lstConta, conta2)
  println(auxConta.number)
  
  lstConta = lstConta.removeElement(lstConta, conta2) // 6.8
  lstConta.printList(lstConta)
    
  lstConta.removeRecursive(lstConta, conta3)
  lstConta.printList(lstConta)
  
  lstConta.freeList(lstConta)
    
  var contaNova : Account = new Account
  contaNova.number=1
  contaNova.amount=100
  var contaPoupanca : SavingsAccount = new SavingsAccount
  contaPoupanca.number=2
  contaPoupanca.amount=200
  var contaFidelidade : FidelityAccount = new FidelityAccount
  contaFidelidade.number = 3
  contaFidelidade.amount=300
  var lstConta2 : AccountList = new AccountList
  lstConta2 = lstConta2.createList()
    
  lstConta2.insertElement(lstConta2, contaNova)  // 6.1
    
  lstConta2.insertElement(lstConta2, contaPoupanca)  // 6.2
    
  lstConta2.insertElement(lstConta2, contaFidelidade)  // 6.4
     
  var contaAux = lstConta2.getElement(lstConta2, contaNova)  // 6.4
  contaAux.credit(10)
  println(contaAux.amount)
    
  var contaAux2 = lstConta2.getElement(lstConta2, contaFidelidade)  // 6.5
  contaAux2.debit(2)
  
  println(contaAux2.amount)  // 6.7
  contaAux2.credit(500)
  
  var contaPoupanca2 : SavingsAccount = new SavingsAccount
  contaPoupanca2.addInterest()
  var contaFidelidade2 : FidelityAccount = new FidelityAccount
  contaFidelidade2.credit(1000)
  contaFidelidade2.concederBonus()
    
  lstConta2.removeElement(lstConta2, contaFidelidade)
    
  lstConta2.printList(lstConta2)
    
  def transferencia( origem : Account, destino: Account, value : Double) : Unit = {
    if(origem.amount>=value){
    origem.amount = origem.amount - value
    destino.amount = destino.amount + value
    }  
    transferencia(contaPoupanca, contaFidelidade,10)
  }
      
  }
}