package Lista10

object Main {
  def main(args: Array[String]){
    var arvore:NodeBTree = new NodeBTree()
    arvore = arvore.insert(10)
    arvore = arvore.insert(9)
    arvore = arvore.insert(12)
    arvore = arvore.insert(13)    
    arvore = arvore.insert(14)
    //primeiro split
    //altura da arvore aumentou
    arvore = arvore.insert(15)    
    arvore = arvore.insert(16)
    arvore = arvore.insert(17)
    //segundo split
    arvore = arvore.insert(18)
    arvore = arvore.insert(19)
    arvore = arvore.insert(20)
    //terceiro split
    arvore = arvore.insert(21)
    arvore = arvore.insert(22)
    arvore = arvore.insert(23)
    //quarto split
    arvore = arvore.insert(24)
    arvore = arvore.insert(25)
    arvore = arvore.insert(26)
    //quinto split
    //altura da arvore aumentou
    
    arvore.printBTreeSimetric(15, 22)
    println()
    arvore.printBTreeSimetric(18, 50)
    println()
  }
}