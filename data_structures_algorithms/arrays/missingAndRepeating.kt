package data_structures_algorithms.arrays

/*
* Given an unsorted array of size n. Array elements are in the range of 1 to n. One number from set {1, 2, ...n} is missing and one number occurs twice in the array. The task is to find these two numbers.
* 
* Examples: 
* 
* Input: arr[] = {3, 1, 3}
* Output: 3, 2
* Explanation: In the array, 2 is missing and 3 occurs twice.
*
* Input: arr[] = {4, 3, 6, 2, 1, 1}
* Output: 1, 5
* Explanation: 5 is missing and 1 is repeating.
*/

fun main() {
    val arr = intArrayOf(4,3,6,2,1,1)
    val n = arr.size
    val ues = findMissingAndRepeating(arr, n)
    println("${ues.first}, ${ues.second}")
}

fun findMissingAndRepeating(arr: IntArray, n: Int): Pair<Int, Int> {
    
    var repeated = 0
    var missed = 0
    for(i in 0 .. n-1) {
        var absIndex = Math.abs(arr[i])
        if(arr[absIndex - 1] < 0) {
            repeated = absIndex
        } else {
        arr[absIndex - 1] = 0 - arr[absIndex - 1]
        }

    }

    for(i in 0..n-1) {
        if(arr[i] > 0) {
            missed = i + 1
        }

    }

    return Pair(missed, repeated)

    }

    