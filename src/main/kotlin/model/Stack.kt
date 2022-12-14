package model

class Stack {
    private val crates: ArrayDeque<Crate> = ArrayDeque()

    fun push(crate: Crate) = crates.addLast(crate)

    fun add(crate: Crate) = crates.addFirst(crate)

    fun pop() = crates.removeLast()

    fun removeAt(index: Int) = crates.removeAt(crates.lastIndex - index)

    fun last() = crates.last()

    fun isEmpty() = crates.isEmpty()
}
