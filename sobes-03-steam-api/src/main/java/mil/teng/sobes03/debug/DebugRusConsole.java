package mil.teng.sobes03.debug;

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
@Fork(value = 1, jvmArgs = {  "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 1, time = 50, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 1, batchSize = 1, time = 50, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class DebugRusConsole {
    public DebugRusConsole() {
        xlog("DebugRusConsole: ctor проверка");
    }

    @Benchmark
    public void nothing() throws InterruptedException {
        long now = System.currentTimeMillis();
        xlog("проверка-",String.valueOf(now));
        Thread.sleep(10);
    }


    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}
