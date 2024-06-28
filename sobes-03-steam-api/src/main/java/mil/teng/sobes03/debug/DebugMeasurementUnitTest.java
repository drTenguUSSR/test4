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
 * отображение единиц времени тестов
 * TimeUnit.MILLISECONDS - ms/op =       10,670
 * TimeUnit.MICROSECONDS - us/op =    10729,639
 * TimeUnit.NANOSECONDS  - ns/op = 10757911,567
 */

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, jvmArgs = {  "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 4, time = 50, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, batchSize = 1, time = 50, timeUnit = TimeUnit.MILLISECONDS)
public class DebugMeasurementUnitTest {
    public DebugMeasurementUnitTest() {
        xlog("DebugMeasurementUnitTest: ctor проверка");
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void measurMilli() throws InterruptedException {
        long now = System.currentTimeMillis();
        Thread.sleep(10);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measurMicro() throws InterruptedException {
        long now = System.currentTimeMillis();
        Thread.sleep(10);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void measurNano() throws InterruptedException {
        long now = System.currentTimeMillis();
        Thread.sleep(10);
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}
