object Main {
    def main(args: Array[String]) {
     
      var hashTable = new Hash()
     
      hashTable.create(10)  // 3.1

      hashTable.insert(88)  // 3.2
      hashTable.insert(23)
      hashTable.insert(4)
      hashTable.insert(80)
      hashTable.insert(170)
      hashTable.insert(972)
      hashTable.insert(87)
      
      
      var tmp : Int = hashTable.search(170)  // 3.3
      println(tmp)

      
      hashTable.remove(88)  // 3.4
      hashTable.search(23)
      
      hashTable.release()  // 3.5
      
    }
}