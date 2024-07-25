package y2024.q912_sort_an_array

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(n)
     */
    fun sortArray(nums: IntArray): IntArray {
        val size = nums.size

        if (size <= 1) return nums

        mergeSort(nums, 0, size - 1)

        return nums
    }

    private fun mergeSort(arr: IntArray, low: Int, high: Int) {
        if (low >= high) return

        // find the middle position
        val mid = (high + low) / 2

        // recursive to split the array into 2 part (lower/higher), until got single-item array
        // sort lower/higher array
        mergeSort(arr, low, mid)
        mergeSort(arr, mid + 1, high)

        // comeback and merge the sorted lower/higher array
        splitAndMerge(arr, low, mid, high)
    }

    private fun splitAndMerge(arr: IntArray, low: Int, mid: Int, high: Int) {
        // calculate size of 2 sub-array
        val lowerSize = mid - low + 1
        val higherSize = high - mid

        // split & build 2 sub-array
        val lowerArr = IntArray(lowerSize)
        var idx = 0
        for (i in low..mid) {
            lowerArr[idx] = arr[i]
            idx++
        }
        idx = 0
        val higherArr = IntArray(higherSize)
        for (j in (mid + 1)..high) {
            higherArr[idx] = arr[j]
            idx++
        }

        // merge 2 sub-array
        var i = 0
        var j = 0
        idx = low
        while (i < lowerSize && j < higherSize) {
            // compare the current number at pointer of each sub-array
            // put the smaller number into the merged array
            if (lowerArr[i] <= higherArr[j]) {
                arr[idx] = lowerArr[i]
                i++
            } else {
                arr[idx] = higherArr[j]
                j++
            }
            idx++
        }

        // copy the remaining numbers from 2 sub-array (if any)
        // into the merged array
        while (i < lowerSize) {
            arr[idx] = lowerArr[i]
            i++
            idx++
        }
        while (j < higherSize) {
            arr[idx] = higherArr[j]
            j++
            idx++
        }
    }
}

fun main() {
    val res = Solution().sortArray(
        intArrayOf(5, 2, 3, 1)
    )
    println(res)
}