package mil.teng.jmh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
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
@Warmup(iterations = 2, time = 300, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 300, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchParamMultiTest {
    public BenchParamMultiTest() {
        xlog("BenchParamCtor called");
    }

    @State(Scope.Benchmark)
    public static class XState {
        public XState() {
            xlog("XStateCtor called. iterations=" + iter + " uuid=" + uuid);
        }

        public final String uuid = shortUUID();

        private long timeBaseOffset;

        @Param({ "1", "3", "6", })
        private int iter;

        @Setup(Level.Iteration)
        public void doInit() throws ParseException {
            String myDate = "2024/06/29 01:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = sdf.parse(myDate);
            this.timeBaseOffset = date.getTime();
            xlog("XStateInit: timeBaseOffset=" + timeBaseOffset + " iter=" + iter + " uuid=" + uuid);

        }
    }

    @Benchmark
    public void simpleR1(XState xstate) throws InterruptedException {
        final int iter = xstate.iter;
        long timeA = System.currentTimeMillis();
        Thread.sleep(1 * iter * 100);
        long timeB = System.currentTimeMillis();
        xlog("simpleR1. iter=" + iter + " x.uuid=" + xstate.uuid + " timeB/timeA=" + (timeB - timeA) + " ms");
    }

    @Benchmark
    public void simpleR3(XState xstate) throws InterruptedException {
        final int iter = xstate.iter;
        long timeA = System.currentTimeMillis();
        Thread.sleep(3 * iter * 100);
        long timeB = System.currentTimeMillis();
        xlog("simpleR3. iter=" + iter + " x.uuid=" + xstate.uuid + " timeB/timeA=" + (timeB - timeA) + " ms");
    }

    @Benchmark
    public void simpleR6(XState xstate) throws InterruptedException {
        final int iter = xstate.iter;
        long timeA = System.currentTimeMillis();
        Thread.sleep(6 * iter * 100);
        long timeB = System.currentTimeMillis();
        xlog("simpleR6. iter=" + iter + " x.uuid=" + xstate.uuid + " timeB/timeA=" + (timeB - timeA) + " ms");
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }

    public static String shortUUID() {
        final long id = UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFF;
        return Long.toString(id, 16);
    }
}
