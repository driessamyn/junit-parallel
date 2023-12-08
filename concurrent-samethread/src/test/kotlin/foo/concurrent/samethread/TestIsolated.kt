package foo.concurrent.samethread

import foo.test.TestClass
import org.junit.jupiter.api.parallel.Isolated

@Isolated
class TestIsolated : TestClass()
