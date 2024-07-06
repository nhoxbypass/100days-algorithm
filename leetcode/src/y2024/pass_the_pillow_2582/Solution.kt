package y2024.pass_the_pillow_2582

class Solution {
    fun passThePillow(n: Int, time: Int): Int {
        val stepNeedPerLoop = n-1
        val fullLoop = (time / stepNeedPerLoop) % 2 == 0
        return if (fullLoop) {
            1 + (time % stepNeedPerLoop)
        } else {
            n - (time % stepNeedPerLoop)
        }
    }
}


fun main() {
    val res = Solution().passThePillow(5, 6)
    println(res)
}