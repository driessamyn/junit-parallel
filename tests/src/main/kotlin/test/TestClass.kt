package foo.test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random

open class TestClass {
    companion object {
        @JvmStatic
        fun manyTimes() = (1..3)
    }

    @ParameterizedTest
    @MethodSource("manyTimes")
    fun test() {
        val sleepFor = Random.nextLong(1500)
        println("[${Thread.currentThread().name}] ${this.javaClass.name} Test 1 going to sleep for $sleepFor ms")
        Thread.sleep(sleepFor)
        println("[${Thread.currentThread().name}] ${this.javaClass.name} Test 1 finish")
    }
}
