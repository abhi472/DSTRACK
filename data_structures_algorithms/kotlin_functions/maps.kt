package data_structures_algorithms.kotlin_functions

fun main() {
    // Creating a map using mapOf()
    val immutableMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    println("Immutable Map: $immutableMap")

    // Accessing elements
    println("Value for key 2: ${immutableMap[2]}")
    println("Value for key 5 (default null): ${immutableMap.getOrDefault(5, "Not Found")}")

    // Creating a mutable map using mutableMapOf()
    val mutableMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    println("Mutable Map: $mutableMap")

    // Adding elements
    mutableMap["d"] = 4
    mutableMap.put("e", 5)
    println("Mutable Map after adding elements: $mutableMap")

    // Removing elements
    mutableMap.remove("b")
    println("Mutable Map after removing element with key 'b': $mutableMap")

    // Iterating over a map
    println("Iterating over mutable map:")
    for ((key, value) in mutableMap) {
        println("Key: $key, Value: $value")
    }

    println("Iterating over entries:")
    for (entry in mutableMap.entries) {
        println("Key: ${entry.key}, Value: ${entry.value}")
    }

    println("Iterating over keys:")
    for (key in mutableMap.keys) {
        println("Key: $key")
    }

    println("Iterating over values:")
    for (value in mutableMap.values) {
        println("Value: $value")
    }

    // Using mapKeys to transform keys
    val upperCaseKeysMap = immutableMap.mapKeys { it.key.toString().uppercase() }
    println("Map with uppercase keys: $upperCaseKeysMap")

    // Using mapValues to transform values
    val doubledValuesMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3).mapValues { it.value * 2 }
    println("Map with doubled values: $doubledValuesMap")

    // Using filterKeys to filter by keys
    val filteredByKeyMap = immutableMap.filterKeys { it > 1 }
    println("Map filtered by key (> 1): $filteredByKeyMap")

    // Using filterValues to filter by values
    val filteredByValueMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3, "d" to 4).filterValues { it % 2 == 0 }
    println("Map filtered by even values: $filteredByValueMap")

    // Checking if a key or value exists
    println("Does map contain key 'a'? ${mutableMap.containsKey("a")}")
    println("Does map contain value 3? ${mutableMap.containsValue(3)}")
}