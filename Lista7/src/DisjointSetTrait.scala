

trait DisjointSetTrait {

  def createSet(tamanho : Int)
  def makeSet()
  def union(elm1 : Int, elm2:Int) 
  def getRep(elm : Int): Int
  def isSameSet(elm1:Int, elm2: Int)
  def release()

}