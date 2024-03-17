To reproduce the problem run

```shell
./run.sh

Does not crash
Was able to allocate array with size 600000000
Crashes with out of memory
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at com.miro.reproduce.App.run(App.kt:9)
	at com.miro.reproduce.App$run$1.invokeSuspend(App.kt)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at com.miro.reproduce.AppKt.main(App.kt:39)
```