fun main() {
    // 🛠️ Array Creation & Initialization
    println("\n🛠️ Array Creation & Initialization")
    val array1 = arrayOf(1, 2, 3)
    println("array1: ${array1.contentToString()}")  // Use contentToString() for array output
    val array2 = arrayOf<Int>(1, 2, 3)
    println("array2: ${array2.contentToString()}")
    val intArray = intArrayOf(1, 2, 3)
    println("intArray: ${intArray.contentToString()}")
    val booleanArray = booleanArrayOf(true, false, true)
    println("booleanArray: ${booleanArray.contentToString()}")
    val array3 = Array(5) { it * 2 }
    println("array3: ${array3.contentToString()}") // [0, 2, 4, 6, 8]

    // Accessing Elements
    println("\nAccessing Elements")
    val arr = arrayOf(10, 20, 30, 40, 50)
    println("arr: ${arr.contentToString()}")
    println("arr[0]: ${arr[0]}")
    println("arr.get(1): ${arr.get(1)}")
    println("arr.first(): ${arr.first()}")
    println("arr.last(): ${arr.last()}")
    println("arr.getOrNull(5): ${arr.getOrNull(5)}") // null, index out of bounds
    println("arr.getOrNull(2): ${arr.getOrNull(2)}")

    // Modifying Elements
    println("\nModifying Elements")
    arr[2] = 35
    println("arr after arr[2] = 35: ${arr.contentToString()}")
    arr.set(3, 45)
    println("arr after arr.set(3, 45): ${arr.contentToString()}")

    // 📏 Array Information
    println("\n📏 Array Information")
    println("arr.size: ${arr.size}")
    println("arr.indices: ${arr.indices}")
    println("arr.isEmpty(): ${arr.isEmpty()}")
    println("arr.isNotEmpty(): ${arr.isNotEmpty()}")

    // ➕ Adding & Removing (Creates New Arrays/Lists)
    println("\n➕ Adding & Removing (Creates New Arrays/Lists)")
    val arr2 = arrayOf(1, 2, 3)
    val newArray1 = arr2 + 4
    println("arr2 + 4: ${newArray1.contentToString()}")
    val newArray2 = arr2 + arrayOf(4, 5)
    println("arr2 + arrayOf(4, 5): ${newArray2.contentToString()}")
    val newArray3 = arr2.plus(6)
    println("arr2.plus(6): ${newArray3.contentToString()}")
    val newArray4 = arr2.plus(arrayOf(7, 8))
    println("arr2.plus(arrayOf(7, 8)): ${newArray4.contentToString()}")
    val list = arr2.toList()
    println("arr2.toList(): $list")

    // 🔍 Searching & Filtering
    println("\n🔍 Searching & Filtering")
    val searchArray = arrayOf("apple", "banana", "cherry", "banana")
    println("searchArray: ${searchArray.contentToString()}")
    println("searchArray.contains(\"banana\"): ${searchArray.contains("banana")}")
    println("searchArray.contains(\"grape\"): ${searchArray.contains("grape")}")
    println("searchArray.indexOf(\"banana\"): ${searchArray.indexOf("banana")}")
    println("searchArray.indexOf(\"grape\"): ${searchArray.indexOf("grape")}")
    println("searchArray.lastIndexOf(\"banana\"): ${searchArray.lastIndexOf("banana")}")
    println("searchArray.lastIndexOf(\"grape\"): ${searchArray.lastIndexOf("grape")}")
    val found = searchArray.find { it.startsWith("b") }
    println("searchArray.find { it.startsWith(\"b\") }: $found")
    val filteredList = searchArray.filter { it.contains("a") }
    println("searchArray.filter { it.contains(\"a\") }: $filteredList")
    val anyStartsWithA = searchArray.any { it.startsWith("a") }
    println("searchArray.any { it.startsWith(\"a\") }: $anyStartsWithA")
    val allStartsWithA = searchArray.all { it.startsWith("a") }
    println("searchArray.all { it.startsWith(\"a\") }: $allStartsWithA")
    val countStartsWithA = searchArray.count { it.startsWith("a") }
    println("searchArray.count { it.startsWith(\"a\") }: $countStartsWithA")

    // ⚙️ Transformation
    println("\n⚙️ Transformation")
    val transformArray = arrayOf(1, 2, 3, 4)
    println("transformArray: ${transformArray.contentToString()}")
    val mappedList = transformArray.map { it * it }
    println("transformArray.map { it * it }: $mappedList")
    val flatMappedList = arrayOf("abc", "def", "ghi").flatMap { it.toList() }
    println("arrayOf(\"abc\", \"def\", \"ghi\").flatMap { it.toList() }: $flatMappedList")

    // 🔪 Sorting
    println("\n🔪 Sorting")
    val sortArray = arrayOf(3, 1, 4, 1, 5, 9, 2, 6)
    println("sortArray: ${sortArray.contentToString()}")
    val sortedList = sortArray.sorted()
    println("sortArray.sorted(): $sortedList")
    val sortedDescendingList = sortArray.sortedDescending()
    println("sortArray.sortedDescending(): $sortedDescendingList")
    val sortedByList = sortArray.sortedBy { -it }
    println("sortArray.sortedBy { -it }: $sortedByList")
    val sortedByDescendingList = sortArray.sortedByDescending { it }
    println("sortArray.sortedByDescending { it }: $sortedByDescendingList")

    // 🔄 Other Useful Operations
    println("\n🔄 Other Useful Operations")
    val otherArray = arrayOf(10, 20, 30, 40, 50)
    println("otherArray: ${otherArray.contentToString()}")
    otherArray.forEach { print("$it ") }
    println()
    otherArray.forEachIndexed { index, element -> println("Index $index: $element") }
    val sum = otherArray.reduce { accumulator, element -> accumulator + element }
    println("otherArray.reduce { accumulator, element -> accumulator + element }: $sum")
    val sumWithInitial = otherArray.fold(100) { accumulator, element -> accumulator + element }
    println("otherArray.fold(100) { accumulator, element -> accumulator + element }: $sumWithInitial")
    otherArray.reverse() // modifies the original array
    println("otherArray.reverse(): ${otherArray.contentToString()}")
    val reversedList = otherArray.reversed() // returns a new reversed List
    println("otherArray.reversed(): $reversedList.  Original otherArray: ${otherArray.contentToString()}")
    val slicedList = otherArray.slice(1..3)
    println("otherArray.slice(1..3): $slicedList")
    val copiedArray = otherArray.copyOf()
    println("otherArray.copyOf(): ${copiedArray.contentToString()}")
    val copiedSizedArray = otherArray.copyOf(10)
    println("otherArray.copyOf(10): ${copiedSizedArray.contentToString()}")
    val copiedRangeArray = otherArray.copyOfRange(2, 5)
    println("otherArray.copyOfRange(2, 5): ${copiedRangeArray.contentToString()}")
}
