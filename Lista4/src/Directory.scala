import scala.List
import scala.util.control.Breaks

class Directory (n: Int){ 
    // diretório da tabela hash expansível
  var depth  : Int = 2                                
	var length : Int = math.pow(2, depth).intValue      
	var dir = new Array[Bucket](length)           
	var capacity = 4                                    
	var maxChainBits = n.toBinaryString.length()	
	
	def hash(key: Int): Int = {
        var bin = bitPattern(maxChainBits, key)
        bin = bin.substring(bin.length-depth, bin.length)
        Integer.parseInt(bin, 2);
    }
    
	def bitPattern(size: Int, value: Int): String = {
	    var bin  = value.toBinaryString
	    var compl = 0
	    var zero: String = ""
	    
	    if (bin.length < size){
	        compl = size - bin.length
	        for (i <- 1 to compl){
	            zero += "0"
	        }
	    }
	    return zero+bin
	}
		
	
	def createHashTable(): Unit = {
	    for (i <- 0 until dir.length){
	        dir(i) = new Bucket(capacity,depth)
	    }
	}
	
	def insert(key: Int): Unit = {
	    
	    var index = hash(key)
	    var bucket = dir(index).insert(key)
	    
	    if(bucket._2){
	        println("Inserting element '" + key + "' into directory["+index+"].");
	        dir(index) = bucket._1
	    }else{
	        println("\n"+"The insertion of elemento '" + key + "' into directory["+index+"] has failed! Bucket is full!");
	        
	        if (depth == bucket._1.depth){
	            /* bucket is full && global depth == local depth */
	            println("\n"+"The table will be resized to allow the inclusion of a new key.");
	            duplicateTable(bucket._1, key)    
	        }else{
	            println("\n"+"A new bucket is been creating to include a new key.");
	            duplicateBacket(bucket._1, key) 
	        }
	    }
	}
	

	def duplicateTable(bucketFull: Bucket, key: Int):Unit = {
	    var indOverflow = hash(key)
	    depth += 1
	    length = math.pow(2, depth).intValue
	    var newDirectory = new Array[Bucket](length)
	        
	    newDirectory(indOverflow) = new Bucket(capacity,depth) 
	    
	    newDirectory(indOverflow + math.pow(2, depth-1).intValue) = new Bucket(capacity,depth)
	  
	    for (i <- 0 until dir.length){
	        if (i != indOverflow) {
	            newDirectory(i) = dir(i)
	        }
	    }
	    
	    for (i <- 0 until dir.length){
	        if ((i + math.pow(2, depth-1).intValue) != (indOverflow + math.pow(2, depth-1).intValue)){
	            newDirectory(i + math.pow(2, depth-1).intValue) = dir(i)
	        }
	    }
	    
        var elem = bucketFull.bucket.toArray	    
	   	        
        for(i <- 0 until elem.length){
	   	    newDirectory(hash(elem(i))).insert(elem(i))    
	   	}
	    
        newDirectory(hash(key)).insert(key)
        
        dir = newDirectory
	}
	
	
	def duplicateBacket(bucketFull: Bucket, key: Int):Unit = {
	    var indOverflow = hash(key)
	    
     	// Dividindo o bucket com overflow 
 		
	    // Buscando referências iguais para o bucket com overflow
	    var equalRef = false
        var equalInd = -1
        for(i <- 0 until dir.length){
            if(dir(indOverflow).equals(dir(i))){
                   equalRef = true
                   equalInd = i
               }
           }
	    
	    // Criando novo bucket para substituir o bucket com overflow
	    dir(equalInd) = new Bucket(capacity,depth) 
	    
	    // Criando novo bucket para a chave que causou o overflow
	    dir(indOverflow) = new Bucket(capacity,depth)
	    
      var elem = bucketFull.bucket.toArray	    
	   	        
      
       for(i <- 0 until elem.length){
	   	    dir(hash(elem(i))).insert(elem(i))    
	   	}
	    
      
       dir(hash(key)).insert(key)
	}
	
	
	def search(key: Int): Unit = {
	    var index = hash(key)
	    if (searchInBucket(dir(index).bucket, key)){
	        println("\n"+"The element '"+key+"' was found in directory["+hash(key)+"]")
	    }else{
	        println("\n"+"Element '"+key+"' not found!")
	    }
	}

    def searchInBucket(bucket: List[Int], key: Int): Boolean = 
        bucket match {
            case Nil      => false
            case x :: Nil => if (x == key) true else false
            case x :: xs  => if (x == key) true else searchInBucket(xs, key)
     }
    
    def remove(key: Int): Unit = {
        var index = hash(key)
        dir(index).bucket = removeOfBucket(dir(index).bucket, key)
        dir(index).depth -= 1
        merge(dir(index),index)        
    }
    
    def removeOfBucket(bucket: List[Int], key: Int): List[Int] = bucket match {
        case Nil      => Nil
        case x :: Nil => if (x == key) Nil else x :: Nil
        case x :: xs  => if (x == key) xs else x :: removeOfBucket(xs, key)
    }
  
    def merge (bucket: Bucket, index:Int) : Unit = {
      if (bucket.bucket == Nil){
          var i = 0
          var l = dir.length-1
              while (i <= l) {
                  if (hashDepth(i,bucket.depth) == hashDepth(index,bucket.depth) && i != index){ 
                    dir(index) = dir(i)
                    i = l
                   }
              i+=1    
              }
          }
 
    }
  
  def hashDepth(index: Int,d:Int): String = {
        var bin: String  = bitPattern(maxChainBits, index)
        bin.substring(bin.length-d, bin.length)
    }    
    
   def display(): Unit = {
       for (i <- 0 until dir.length) {
           var (equalRef,equalInd) = repeatedRef(i)
           if (!equalRef) {
               var elementos = dir(i).bucket.toArray
               var seq:String = "|"
                   for (j <- 0 until elementos.length) {
                      seq +=" "+ elementos(j)+" |" 
                   }
               println("Bucket's elements into directory["+i+"] : " + seq)
            }else{
               println("Bucket's elements into directory["+i+"] : " + "Indexes to directory["+equalInd+"]")
            }
       }         
   }
   
   def repeatedRef(indCurrent: Int): (Boolean, Int) = {
       var equalRef = false
       var equalInd = -1
       
       for(j <- indCurrent-1 to 0 by -1){
               if (dir(indCurrent).equals(dir(j))){
                   equalRef = true
                   equalInd = j
               }
           }
       return (equalRef,equalInd)
   }
	
}