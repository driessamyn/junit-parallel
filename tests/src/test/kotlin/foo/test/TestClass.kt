package foo.test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random

class TestClass2 {
    companion object {
        @JvmStatic
        fun manyTimes() = (1..100)
    }

    @ParameterizedTest
    @MethodSource("manyTimes")
    fun test() {
        val sleepFor = Random.nextLong(2000)
        println("[${Thread.currentThread().name}] Test 1 going to sleep for $sleepFor ms")
        Thread.sleep(sleepFor)
        println("[${Thread.currentThread().name}] Test 1 finish")
    }
}
