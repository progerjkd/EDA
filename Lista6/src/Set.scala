

class Set(var values : Array[String], var bits : Int) {
  
  def this(values : Array[String]){
    this(values, 0)
  }
  
  def insert(value : String) : Unit = {
    for(i<- 0 until values.length){
      if(values(i).==(value)){
        turnOnBit(i)
        return
      }
    }
  }
  
   def turnOnBit(i : Int) : Unit = {
    if(!isOn(i))
      bits += Math.pow(2,i).toInt
  }
  
   def isOn(i:Int): Boolean ={
    var mask = 1 << i
    return ((mask & bits) != 0)
  }
  
  def print(): Unit ={
    for(i<- 0 until values.length){
      if(isOn(i)){
        println(values(i))
      }
    }
   println()
  }

  def remove(value : String): Unit = {
    for(i<- 0 until values.length){
      if(values(i).==(value)){
        turnOffBit(i)
        return
      }
    }
  }

  def union(set : Set) : Int = {
    return set.bits | bits;
  }

  def intersection(set : Set) : Int = {
    return set.bits & bits;
  }

  def difference(set : Set) : Int = {
    if(set.bits < bits) return bits - set.bits
    else return set.bits - bits;
  }

  def isSubSet(set : Set) : Boolean = {
    if((bits & set.bits) == set.bits && (bits | set.bits) == bits){ return true}
    return false
  }

  def isEqual(set : Set): Boolean = {
    return (bits == set.bits)
  }

  def complement(): Int ={
    return ~bits
  }

  def belongs(value : String) : Boolean = {
    for(i<- 0 until values.length){
      if(values(i).==(value)){
        return isOn(i)
      }
    }
    return false
  }

  def numberOfElements() : Int = {
    var value = bits
    var bit = 0
    var count = 0
    
    while(value != 0){
      bit = value % 2
      if(bit == 1) count.+(1)
      value = value / 2
    }
    return count
  }

  def free() : Unit = {
    for(i<-0 until values.length){
      values(i) = null
    }
    values = null
  }

 

  def turnOffBit(i:Int): Unit ={
    if(isOn(i))
      bits -= Math.pow(2, i).toInt
  }

 

  




}