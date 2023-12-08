# JUnit 5 Parallel testing

Validation of behaviour of difference configuration and annotations:

## concurrent/concurrent

```groovy
    systemProperties([
            // Configuration parameters to execute top-level classes in parallel but methods in same thread
            'junit.jupiter.execution.parallel.enabled'                 : 'true',
            'junit.jupiter.execution.parallel.mode.default'            : 'concurrent',
            'junit.jupiter.execution.parallel.mode.classes.default'    : 'concurrent',
    ])
```

```shell
./gradlew clean concurrent-concurrent:test
```

```shell
> Task :concurrent-concurrent:test

Test2 > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-5] foo.concurrent.concurrent.Test1 Test 1 going to sleep for 1303 ms

Test1 > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.concurrent.TestSameThread Test 1 going to sleep for 669 ms
    [ForkJoinPool-1-worker-2] foo.concurrent.concurrent.Test1 Test 1 going to sleep for 710 ms
    [ForkJoinPool-1-worker-8] foo.concurrent.concurrent.Test2 Test 1 going to sleep for 1230 ms
    [ForkJoinPool-1-worker-9] foo.concurrent.concurrent.Test2 Test 1 going to sleep for 1033 ms
    [ForkJoinPool-1-worker-7] foo.concurrent.concurrent.Test1 Test 1 going to sleep for 1251 ms
    [ForkJoinPool-1-worker-6] foo.concurrent.concurrent.Test2 Test 1 going to sleep for 1449 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.concurrent.TestSameThread Test 1 finish

TestSameThread > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.concurrent.TestSameThread Test 1 going to sleep for 1065 ms
    [ForkJoinPool-1-worker-2] foo.concurrent.concurrent.Test1 Test 1 finish

Test1 > test() STANDARD_OUT
    [ForkJoinPool-1-worker-9] foo.concurrent.concurrent.Test2 Test 1 finish

Test2 > test() STANDARD_OUT
    [ForkJoinPool-1-worker-8] foo.concurrent.concurrent.Test2 Test 1 finish
    [ForkJoinPool-1-worker-7] foo.concurrent.concurrent.Test1 Test 1 finish

Test1 > test() STANDARD_OUT
    [ForkJoinPool-1-worker-5] foo.concurrent.concurrent.Test1 Test 1 finish

Gradle Test Executor 22 STANDARD_OUT
    [ForkJoinPool-1-worker-6] foo.concurrent.concurrent.Test2 Test 1 finish
    [ForkJoinPool-1-worker-1] foo.concurrent.concurrent.TestSameThread Test 1 finish

TestSameThread > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.concurrent.TestSameThread Test 1 going to sleep for 1023 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.concurrent.TestSameThread Test 1 finish

TestIsolated > test() > [1]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.concurrent.concurrent.TestIsolated Test 1 going to sleep for 83 ms
    [ForkJoinPool-1-worker-4] foo.concurrent.concurrent.TestIsolated Test 1 finish

TestIsolated > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.concurrent.concurrent.TestIsolated Test 1 going to sleep for 53 ms
    [ForkJoinPool-1-worker-4] foo.concurrent.concurrent.TestIsolated Test 1 finish

TestIsolated > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.concurrent.concurrent.TestIsolated Test 1 going to sleep for 684 ms
    [ForkJoinPool-1-worker-4] foo.concurrent.concurrent.TestIsolated Test 1 finish
```

## concurrent/same_thread

```groovy
    systemProperties([
        // Configuration parameters to execute top-level classes in parallel but methods in same thread
        'junit.jupiter.execution.parallel.enabled'                 : 'true',
        'junit.jupiter.execution.parallel.mode.default'            : 'concurrent',
        'junit.jupiter.execution.parallel.mode.classes.default'    : 'same_thread',
])
```

```shell
./gradlew clean concurrent-samethread:test
```

```shell
❯ ./gradlew clean concurrent-samethread:test

> Task :concurrent-samethread:test

Test1 > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.concurrent.samethread.Test1 Test 1 going to sleep for 807 ms
    [ForkJoinPool-1-worker-2] foo.concurrent.samethread.Test1 Test 1 going to sleep for 443 ms
    [ForkJoinPool-1-worker-3] foo.concurrent.samethread.Test1 Test 1 going to sleep for 124 ms
    [ForkJoinPool-1-worker-3] foo.concurrent.samethread.Test1 Test 1 finish

Test1 > test() STANDARD_OUT
    [ForkJoinPool-1-worker-2] foo.concurrent.samethread.Test1 Test 1 finish
    [ForkJoinPool-1-worker-4] foo.concurrent.samethread.Test1 Test 1 finish

Test2 > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.concurrent.samethread.Test2 Test 1 going to sleep for 1159 ms
    [ForkJoinPool-1-worker-6] foo.concurrent.samethread.Test2 Test 1 going to sleep for 453 ms
    [ForkJoinPool-1-worker-2] foo.concurrent.samethread.Test2 Test 1 going to sleep for 919 ms
    [ForkJoinPool-1-worker-6] foo.concurrent.samethread.Test2 Test 1 finish

Test2 > test() STANDARD_OUT
    [ForkJoinPool-1-worker-2] foo.concurrent.samethread.Test2 Test 1 finish
    [ForkJoinPool-1-worker-4] foo.concurrent.samethread.Test2 Test 1 finish

TestIsolated > test() > [1]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestIsolated Test 1 going to sleep for 49 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestIsolated Test 1 finish

TestIsolated > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestIsolated Test 1 going to sleep for 585 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestIsolated Test 1 finish

TestIsolated > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestIsolated Test 1 going to sleep for 1062 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestIsolated Test 1 finish

TestSameThread > test() > [1]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestSameThread Test 1 going to sleep for 657 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestSameThread Test 1 finish

TestSameThread > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestSameThread Test 1 going to sleep for 461 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestSameThread Test 1 finish

TestSameThread > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestSameThread Test 1 going to sleep for 380 ms
    [ForkJoinPool-1-worker-1] foo.concurrent.samethread.TestSameThread Test 1 finish
```

## same_thread/concurrent

```groovy
    systemProperties([
            // Configuration parameters to execute top-level classes in parallel but methods in same thread
            'junit.jupiter.execution.parallel.enabled'                 : 'true',
            'junit.jupiter.execution.parallel.mode.default'            : 'same_thread',
            'junit.jupiter.execution.parallel.mode.classes.default'    : 'concurrent',
    ])
```

```shell
./gradlew clean samethread-concurrent:test
```

```shell
❯ ./gradlew clean samethread-concurrent:test

> Task :samethread-concurrent:test

TestSameThread > test() > [1]  STANDARD_OUT
    [ForkJoinPool-1-worker-3] foo.samethread.concurrent.Test2 Test 1 going to sleep for 19 ms
    [ForkJoinPool-1-worker-2] foo.samethread.concurrent.Test1 Test 1 going to sleep for 984 ms
    [ForkJoinPool-1-worker-1] foo.samethread.concurrent.TestSameThread Test 1 going to sleep for 793 ms
    [ForkJoinPool-1-worker-3] foo.samethread.concurrent.Test2 Test 1 finish

Test2 > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-3] foo.samethread.concurrent.Test2 Test 1 going to sleep for 224 ms
    [ForkJoinPool-1-worker-3] foo.samethread.concurrent.Test2 Test 1 finish

Test2 > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-3] foo.samethread.concurrent.Test2 Test 1 going to sleep for 1274 ms
    [ForkJoinPool-1-worker-1] foo.samethread.concurrent.TestSameThread Test 1 finish

TestSameThread > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.samethread.concurrent.TestSameThread Test 1 going to sleep for 593 ms
    [ForkJoinPool-1-worker-2] foo.samethread.concurrent.Test1 Test 1 finish

Test1 > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-2] foo.samethread.concurrent.Test1 Test 1 going to sleep for 239 ms
    [ForkJoinPool-1-worker-2] foo.samethread.concurrent.Test1 Test 1 finish

Test1 > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-2] foo.samethread.concurrent.Test1 Test 1 going to sleep for 1423 ms
    [ForkJoinPool-1-worker-1] foo.samethread.concurrent.TestSameThread Test 1 finish

TestSameThread > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.samethread.concurrent.TestSameThread Test 1 going to sleep for 495 ms
    [ForkJoinPool-1-worker-3] foo.samethread.concurrent.Test2 Test 1 finish

Gradle Test Executor 25 STANDARD_OUT
    [ForkJoinPool-1-worker-1] foo.samethread.concurrent.TestSameThread Test 1 finish
    [ForkJoinPool-1-worker-2] foo.samethread.concurrent.Test1 Test 1 finish

TestIsolated > test() > [1]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.samethread.concurrent.TestIsolated Test 1 going to sleep for 792 ms
    [ForkJoinPool-1-worker-4] foo.samethread.concurrent.TestIsolated Test 1 finish

TestIsolated > test() > [2]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.samethread.concurrent.TestIsolated Test 1 going to sleep for 642 ms
    [ForkJoinPool-1-worker-4] foo.samethread.concurrent.TestIsolated Test 1 finish

TestIsolated > test() > [3]  STANDARD_OUT
    [ForkJoinPool-1-worker-4] foo.samethread.concurrent.TestIsolated Test 1 going to sleep for 1273 ms
    [ForkJoinPool-1-worker-4] foo.samethread.concurrent.TestIsolated Test 1 finish
```