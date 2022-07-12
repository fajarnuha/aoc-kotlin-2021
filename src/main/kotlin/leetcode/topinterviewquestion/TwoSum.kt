package leetcode.topinterviewquestion


/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * */
class TwoSum {

    // Not Solved
    fun twoSumWithSort(nums: IntArray, target: Int): IntArray {

        // Bubble Sort
        for (i in (0 until nums.size - 1)) {
            for (j in i + 1 downTo 0) {
                if (nums[j] < nums[j - 1]) {
                    val temp = nums[j - 1]
                    nums[j - 1] = nums[j]
                    nums[j] = temp
                } else {
                    break
                }
            }
        }
        var newArr = nums.copyOf()

        fun findMidNumber(nums: IntArray, target: Int): IntArray {
            val mi = nums.size / 2
            val half = nums[mi]
            return if (target < half) {
                findMidNumber(nums.copyOfRange(0, mi), target)
            } else {
                nums
            }
        }
        return findMidNumber(nums, target)
    }

    fun twoSumWithMap(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in (0 .. nums.size)) {
            val v = target - nums[i]
            if (map.containsKey(v)) return intArrayOf(map[v]!!, i)
            else map[nums[i]] = i
        }
        return intArrayOf()
    }
}

fun main() {
    val result = TwoSum().twoSumWithMap(intArrayOf(1, 2, 4, 7, 10, 11, 15), 9)
    println("Your answers: ${result.joinToString()}")
}