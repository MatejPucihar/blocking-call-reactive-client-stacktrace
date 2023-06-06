run `./mvnw compile quarkus:dev`
visit http://localhost:8080/test/callMeFromSwagger in the browser. (or on the dev-ui swagger-ui)
inspect the stacktrace, there is no information about the caller of the restclient (TestResource.callMeFromSwagger(..))

```
2023-06-06 08:34:49,262 ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-1) HTTP Request to /test/callMeFromSwagger failed, error id: 1ef6343d-3100-4dc1-8ac0-cfe8b829de5a-1: org.jboss.resteasy.reactive.ClientWebApplicationException: Received: 'Bad Request, status code 400' when invoking: Rest Client method: 'org.example.SelfClient#callMeWithRestClient'
        at org.jboss.resteasy.reactive.client.impl.RestClientRequestContext.unwrapException(RestClientRequestContext.java:185)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.handleException(AbstractResteasyReactiveContext.java:322)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:173)
        at org.jboss.resteasy.reactive.client.impl.RestClientRequestContext$1.lambda$execute$0(RestClientRequestContext.java:295)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:264)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:246)
        at io.vertx.core.impl.EventLoopContext.lambda$runOnContext$0(EventLoopContext.java:43)
        at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:174)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:167)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:566)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: jakarta.ws.rs.WebApplicationException: Bad Request, status code 400
        at io.quarkus.rest.client.reactive.runtime.DefaultMicroprofileRestClientExceptionMapper.toThrowable(DefaultMicroprofileRestClientExceptionMapper.java:18)
        at io.quarkus.rest.client.reactive.runtime.MicroProfileRestClientResponseFilter.filter(MicroProfileRestClientResponseFilter.java:52)
        at org.jboss.resteasy.reactive.client.handlers.ClientResponseFilterRestHandler.handle(ClientResponseFilterRestHandler.java:21)
        at org.jboss.resteasy.reactive.client.handlers.ClientResponseFilterRestHandler.handle(ClientResponseFilterRestHandler.java:10)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.invokeHandler(AbstractResteasyReactiveContext.java:229)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:145)
        ... 12 more

```
