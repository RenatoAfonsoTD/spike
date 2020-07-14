class Service {

    fun solution(entryArray: Array<Int>): Int {

        if (entryArray.size == 1) {
            return 1
        }

        val upwardsSet = mutableSetOf<Int>()
        val downwardsSet = mutableSetOf<Int>()

        var currentUpwardsMax: Int = 0
        var currentDownwardsMax: Int = 0

        for (num in entryArray) {
            var numberAddThisIteration = false

            if (!upwardsSet.contains(num)){
                upwardsSet.add(num)
                numberAddThisIteration = true

                if (num > currentUpwardsMax) {
                    currentUpwardsMax = num
                }
            }

            if (!downwardsSet.contains(num) && !numberAddThisIteration) {
                downwardsSet.add(num)

                if (num > currentDownwardsMax) {
                    currentDownwardsMax = num
                }
            }
        }

        val spikeLength = upwardsSet.size + downwardsSet.size

        if (currentUpwardsMax == currentDownwardsMax) {
            return spikeLength - 1
        }

        return spikeLength
    }
}