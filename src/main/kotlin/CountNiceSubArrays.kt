package br.ufrpe

fun main() {
    val numbers = intArrayOf(1,  1, 2, 1, 1)
    val k = 2
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val numsZeroOne = nums.map { if(it % 2 == 0) 0 else 1 }
        println(numsZeroOne)
        val pref = MutableList(numsZeroOne.size + 1) { 0 }
        for(i in numsZeroOne.indices) {
            pref[i + 1] = pref[i] + numsZeroOne[i]
        }
        pref.removeFirst()

        var result = 0
        val subArrayCount = mutableMapOf(0 to 1)
         for(n in pref) {
             val minArray = n - k
             if(subArrayCount.keys.contains(minArray)) result += subArrayCount[minArray]!!
             subArrayCount[n] = (subArrayCount[n] ?: 0) + 1

         }

        println(pref)
        return result
    }
    println("Example 1")
    println("the number of subArrays is " + numberOfSubarrays(intArrayOf(1,1,2,1,1), 3))
    println("Example 2")
    println("the number of subArrays is " +numberOfSubarrays(intArrayOf(2,2,2,1,2,2,1,2,2,2,1), 2))
}



