package y2024.find_the_winner_of_the_circular_game_1823


class Solution {
    fun findTheWinner(n: Int, k: Int): Int {
        // init friend list with value 1 (IN) / 0 (OUT)
        val friends = MutableList(n) { 1 }

        var friendsLeft = n
        var currPos = 0
        while (friendsLeft > 1) {
            // find the next loser
            val loserPos = findTheNextLoser(n, k, currPos, friends)
            // remove
            friends.set(loserPos, 0)
            friendsLeft--
            // mark new start position to continue the loop
            currPos = loserPos
        }

        // return the last friend with 1 (IN) value
        return friends.indexOf(1) + 1
    }

    private fun findTheNextLoser(n: Int, k: Int, startPos: Int, friends: List<Int>): Int {
        var count = 0
        var currPos = startPos
        while (true) {
            if (friends.get(currPos) == 1) {
                // friend at current pos is still IN
                // count as one
                count++
            }
            if (count >= k) {
                // gotcha
                return currPos
            }
            // move on to the next one
            if (currPos == (n - 1)) {
                // reached the last friend
                // come back to the first one
                currPos = 0
            } else {
                currPos++
            }
        }
    }
}


fun main() {
    val res = Solution().findTheWinner(5, 2)
    println(res)
}