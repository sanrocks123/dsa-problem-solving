/* (C) 2019 */
package designpatterns;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source ThreadPoolTest.java created on Dec 24, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ThreadPoolTest {

    private class MyThreadPoolService {

        private volatile BlockingQueue<Runnable> taskQueue = null;
        private volatile boolean isRunning = true;

        /**
         * @param threads
         */
        public MyThreadPoolService(int threads) {
            taskQueue = new ArrayBlockingQueue<Runnable>(threads);
            for (int i = 1; i <= threads; i++) {
                new WorkerThread(this).start();
            }
        }

        /**
         * @param task
         */
        public void execute(Runnable task) {
            if (isRunning) {
                try {
                    taskQueue.offer(task, 5, TimeUnit.SECONDS);
                } catch (final InterruptedException e) {
                    log.error("Failure to submit task");
                }
            }
            log.info("Stopped accepting new tasks");
        }

        /** */
        public void stop() {
            isRunning = false;
            log.info("Execution stop requested");
        }
    }

    private class WorkerThread extends Thread {

        private final MyThreadPoolService myThreadPoolService;

        /**
         * @param myThreadPoolService
         */
        public WorkerThread(MyThreadPoolService myThreadPoolService) {
            this.myThreadPoolService = myThreadPoolService;
        }

        /** */
        @Override
        public void run() {
            while (this.myThreadPoolService.isRunning) {
                try {
                    this.myThreadPoolService.taskQueue.poll(5, TimeUnit.SECONDS).run();
                } catch (final InterruptedException e) {
                    log.error("Error executing task");
                }
            }
            log.info("Stopped worker thread");
        }
    }

    private final Logger log = LoggerFactory.getLogger(getClass());

    /** */
    @Test
    // @Ignore
    public void testStartPool() {
        final MyThreadPoolService poolService = new MyThreadPoolService(5);

        for (int i = 0; i < 10; i++) {
            poolService.execute(
                    () -> {
                        try {
                            log.info("Picked up for execution");
                            TimeUnit.SECONDS.sleep(5);
                            log.info("Done!!");
                        } catch (final InterruptedException e) {
                            log.error("Error running your task", e);
                        }
                    });
        }
        poolService.stop();
    }
}
