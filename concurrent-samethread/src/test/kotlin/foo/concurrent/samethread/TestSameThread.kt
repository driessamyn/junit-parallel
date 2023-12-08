package foo.concurrent.samethread

import foo.test.TestClass
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Execution(ExecutionMode.SAME_THREAD)
class TestSameThread : TestClass()
