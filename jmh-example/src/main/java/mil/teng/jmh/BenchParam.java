package mil.teng.jmh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * @author DrTengu, 2024/06
 */

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class BenchParam {
    @State(Scope.Benchmark)
    public static class XState {
        private long initOffset;

        @Param({ "100", "200" })
        public int iterations;

        @Setup(Level.Trial)
        public void doInit() throws ParseException {
            String myDate = "2024/06/25 22:04:45";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = sdf.parse(myDate);
            long millis = date.getTime();
            xlog("doInit:" + millis);
            this.initOffset = millis;
        }
    }

    @Benchmark
    @Measurement(iterations = 2, batchSize = 1, time = 6, timeUnit = TimeUnit.SECONDS)
    public void simple(XState xstate) throws InterruptedException {
        Thread.sleep(300);
        long now = System.currentTimeMillis();
        final int iter = xstate.iterations;
        xlog("BenchParam-simple. delta=" + (now - xstate.initOffset) + " iter=" + iter);
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }

}
