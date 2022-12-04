package model

data class Range(val start: Int, val end: Int) {

    fun fullyContains(otherRange: Range): Boolean {
        if (start <= otherRange.start && end >= otherRange.end)
            return true
        if (end >= otherRange.start && end <= otherRange.end)
            return true
        return false
    }
}
