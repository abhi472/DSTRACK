package data_structures_algorithms.sorting_searching

fun main() {

    val arr: IntArray = intArrayOf(2, 0, 2, 2, 1, 0, 1, 1, 2, 1, 2, 0, 0, 0, 2, 1)
    val n = arr.size
    println(sort012(arr, n).contentToString())

}

fun sort012(arr: IntArray, n: Int): IntArray {

    var lo = 0;
    var mid = 0;
    var hi = n - 1;

    while(mid<=hi) {
        if(arr[mid] == 0) {
            var temp = arr[mid] 
            arr[mid] = arr[lo] 
            arr[lo] = temp
            mid++
            lo++
        } else if(arr[mid] == 1) {
            mid++
        } else if(arr[mid] == 2) {
            var temp = arr[mid]
            arr[mid] = arr[hi]
            arr[hi] = temp
            hi--;
        }
    }

    return arr
}
