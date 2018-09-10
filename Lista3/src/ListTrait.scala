

trait ListTrait {
  def createList(): List
  def insertElement(lst:List,elm:Int):List
  def printList(lst : List):Unit
  def printRecursive(lst : List):List
  def printReverse(lst : List):List
  def hasElement(lst : List): Int
  def getElement(lst:List, elm:Int): List
  def removeElement(lst:List, elm:Int): List
  def removeRecursive(lst: List, elm:Int): List
  def freeList(lst:List):List
  
}