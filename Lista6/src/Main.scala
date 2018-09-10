

object Main {

	def main(args: Array[String]): Unit = {

			print("Enter the number os elements: ")
			var size = readInt()

			var values : Array[String] = new Array[String] (size)

			for(i<- 0 until size){
				values(i) = ""+i
			}

			var mySet : Set = new Set(values)  // 6.1

			mySet.insert("0")  // 6.2
			mySet.insert("6")
			mySet.insert("5")
			mySet.insert("4")
			mySet.insert("8")
			mySet.print()

			System.out.println("Removing 8...")
			mySet.remove("8")    // 6.3
			mySet.print()


			var otherSet : Set = new Set(values)

			otherSet.insert("1")
			otherSet.insert("2")
			otherSet.insert("3")
			otherSet.insert("4")
			println("Joining two sets...")
			otherSet.bits = mySet.union(otherSet)  // 6.4
			otherSet.print()



			//5 - Fazer a interseção entre dois conjuntos

			var newSet:Set = new Set(values)
			newSet.insert("1")
			newSet.insert("6")
			println("Intersection of two sets...")
			newSet.bits = (mySet.intersection(newSet))  // 6.5
			newSet.print()


			otherSet.bits = otherSet.difference(newSet)  // 6.6
			println("Difference between two sets")
			otherSet.print()

			if(otherSet.isSubSet(mySet)){    // 6.7
	  		println("Set mySet is a subset of otherSet")
			} else {
			  println("The set mySet is not a subset of otherSet")
			}

			if(mySet.isEqual(otherSet)){    // 6.8
				println("Equal sets\n")
			} else {
				println("Not equal sets\n")
			}

			newSet.bits = mySet.complement()    // 6.9
			println("Complement of set 3")
			newSet.print()

  		
			if(mySet.belongs("1")){    // 6.10
  			println("Belongs\n")
			} else {
		  	println("Do not belongs\n")
  		}
			
			
			println("Number of elements: ")
			println(mySet.numberOfElements())  // 6.11


			mySet.free()    // 6.12
			otherSet.free()
			newSet.free()

  }

}