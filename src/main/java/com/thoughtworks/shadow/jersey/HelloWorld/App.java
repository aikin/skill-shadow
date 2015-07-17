package com.thoughtworks.shadow.jersey.HelloWorld;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/base/");
    public static final String ROOT_PATH = "helloworld";
    private static final Logger logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {

        logger.info("\"Hello World\" Jersey Example App");

        try {
            final ResourceConfig resourceConfig = new ResourceConfig(HelloWorldResource.class);
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);

            System.out.println(String.format("Application started.\nTry out %s%s\nStop the application using CTRL+C",
                    BASE_URI, ROOT_PATH));
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info("in run"); //方法可以给当前的进程注册一个清理线程，当进程退出的时候，会执行线程中的代码
                    server.shutdownNow();
                }
            }));
            server.start();     // 另一个线程，相当于异步

            Thread.currentThread().join(); // 能够使调用 server.start() 的线程在 main 结束前执行完毕，join 可以设置等待多长时间，该等待时间要在拿到释放锁之后才开始算
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        }

    }
}
