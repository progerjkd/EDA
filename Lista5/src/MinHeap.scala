import scala.collection.mutable.ArrayBuffer


class MinHeap (n: Int) {
    
    var heap = new ArrayBuffer[Int]  
    var end = 0
    
    def size() = heap.size
         
    def isEmpty: Boolean = size == 0  

    def insert(key:Int): Unit = {
         heap.insert(end, key)
         bubbleUp(end)
         end += 1
    }
    
    def bubbleUp(pos: Int): Unit = {
        val current = heap(pos)
        val parent  = heap((pos-1)/2)
            if (pos != 0 && current < parent) {
                heap.update((pos-1)/2, current)
                heap.update(pos, parent)
                bubbleUp((pos-1)/2)
            }
    }
    
    def bubbleDown(pos: Int): Unit = {
        val lChildPos = 2 * pos + 1
            if (lChildPos > size) return
            val rChildPos = lChildPos + 1
            val lChild = heap(lChildPos)
            val maxPos = {
                    if (rChildPos < size){
                        if (heap(rChildPos) < lChild) {
                            rChildPos
                        }else{
                            lChildPos
                        }
                    }else{
                      lChildPos
                    }
                }
        val max = heap(maxPos)
        if (max < heap(pos)) {
            val current = heap(pos)
            heap.update(maxPos, current)
            heap.update(pos, max)
        }
        bubbleDown(maxPos)
    }
    
    def updateValue(key: Int, newValue: Int): Unit = {
        if(!isEmpty){
           var ind = searchInHeap(key)
           if (ind != -1){
               heap.update(ind, newValue)
               if (ind > 0 && heap(ind) < heap((ind-1)/2)) bubbleUp(ind) else bubbleDown(ind)
           } else println("Heap doesn't has element "+key)
        } else println("Heap is empty")
    }
    
    
    def searchInHeap(key: Int): Int = {
        var ind = -1
        for (i <- 0 until size){
            if (key == heap(i)) ind = i 
        }
        return ind
    }
    
    def search(key: Int): Unit = {
        var ind = searchInHeap(key)
        if (ind != -1) {
            println("Element " + key + " found in position "+"["+ind+"]")
        }else{
            println("Element not found")
        }
    }
    
    def remove(key: Int): Unit = {
 	    
        println("\nRemoving element: " + key + "\n")

        val ind = searchInHeap(key)
	        if (ind != -1) {
	            val delKey = heap(ind)
	            val last = heap.remove(size-1)
	            heap.update(ind, last)
	            if(ind > 0 && last < heap((ind-1)/2)) bubbleUp(ind) else bubbleDown(ind)
	      }else
	           println("Heap doesn't has element "+key)
    }
    
    def display(): Unit = {
        var seq:String = "|"
        for (i <- 0 until size) {
            seq +=" "+ heap(i)+" |" 
        }
        println("Heap:\n" + seq + "\n")
    }
   
}