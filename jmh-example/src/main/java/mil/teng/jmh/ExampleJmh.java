/**
 * @author DrTengu, 2024/06
 */

package mil.teng.jmh;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class ExampleJmh {
    @Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, batchSize = 1)
    @Fork(value = 2)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void sleep300msA() throws InterruptedException {
        Thread.sleep(300);
        xlog("execNothing called. this=" + this.toString()+" now="+System.currentTimeMillis());
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }

}
