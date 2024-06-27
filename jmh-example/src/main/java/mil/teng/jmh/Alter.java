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
    private static final long timeOffset = 1719526289928L;

    @Benchmark
    @Warmup(iterations = 1, time = 300, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 6, batchSize = 1, time = 2)
    @Fork(value = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void alter100a(ExampleJmh.XState xstate) throws InterruptedException {
        long nowA = System.currentTimeMillis() - timeOffset;
        Thread.sleep(260);
        long nowB = System.currentTimeMillis() - timeOffset;
        xlog("alter100a. nowA=" + nowA + " nowB=" + nowB);
    }

    public void dontRun() throws InterruptedException {
        Thread.sleep(260);
        long now = System.currentTimeMillis();
        xlog("Alter-dontRun");
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }
}
