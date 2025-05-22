/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n]
 * inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and using only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 * **/

fun main() {
    val arr = intArrayOf(1,3,4,2,2)
    println(exactlyOneRepeating(arr))
}

fun exactlyOneRepeating(arr:IntArray): Int {

    var slow = arr[0]
    var fast = arr[0]
    do {
        slow = arr[slow]
        fast = arr[arr[fast]]

    } while (slow != fast)

    var ptr1 = arr[0]
    var ptr2 = slow

    while (ptr1 != ptr2) {
        ptr1 = arr[ptr1]
        ptr2 = arr[ptr2]
    }

    return ptr1
}