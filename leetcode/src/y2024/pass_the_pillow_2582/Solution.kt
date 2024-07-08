package y2024.pass_the_pillow_2582

class Solution {
    fun passThePillow(n: Int, time: Int): Int {
        // calculate steps need for each loop
        val stepNeedPerLoop = n - 1
        // check full loop or not
        // Ex:
        // - START -> END -> on the way back to START ===> false
        // - START -> on the way to END ===> true
        // - START -> END -> START -> on the way to END ===> true
        val fullLoop = (time / stepNeedPerLoop) % 2 == 0
        return if (fullLoop) {
            // count position from START
            1 + (time % stepNeedPerLoop)
        } else {
            // count position from END
            n - (time % stepNeedPerLoop)
        }
    }
}


fun main() {
    val res = Solution().passThePillow(5, 6)
    println(res)
}