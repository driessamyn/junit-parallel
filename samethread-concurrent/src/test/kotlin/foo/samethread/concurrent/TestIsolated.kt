package foo.samethread.concurrent

import foo.test.TestClass
import org.junit.jupiter.api.parallel.Isolated

@Isolated
class TestIsolated : TestClass()
