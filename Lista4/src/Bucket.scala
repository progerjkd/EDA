import scala.List

class Bucket (capacity: Int, newDepth: Int) {
    
  var bucket: List[Int] = Nil
	var depth = newDepth
	var numElem = 0
		
    def insert (key: Int): (Bucket,Boolean) = {
        var isInserted = false
        
        if (numElem < capacity) {
            numElem += 1
            bucket = key::bucket
            isInserted = true
        }else{
            bucket = bucket
            isInserted = false
        }
        return (this,isInserted)
    }
}