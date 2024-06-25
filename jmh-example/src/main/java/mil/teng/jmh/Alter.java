package mil.teng.jmh;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

/**
 * @author DrTengu, 2024/06
 */
@BenchmarkMode(Mode.AverageTime)
public class Alter {
    //@Benchmark
    @Warmup(iterations = 2, time = 300, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, batchSize = 1, time = 2)
    @Fork(value = 2)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void alter100a(ExampleJmh.XState xstate) throws InterruptedException {
        Thread.sleep(100);
        long now = System.currentTimeMillis();
        xlog("alter100a");
    }

    public void dontRun() throws InterruptedException {
        Thread.sleep(100);
        long now = System.currentTimeMillis();
        xlog("Alter-dontRun");
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }
}
