package mil.teng.jmh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
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
@Warmup(iterations = 2, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class BenchParam {

    public BenchParam() {
        xlog("BenchParamCtor called");
    }

    @State(Scope.Benchmark)
    public static class XState {
        public XState() {
            xlog("XStateCtor called. iterations=" + iterations + " uuid=" + uuid);
        }

        public String uuid = shortUUID();

        private long timeBaseOffset;

        @Param({ "3", "6" })
        public int iterations;

        public List<String> randString;

        @Setup(Level.Trial)
        public void doInit() throws ParseException {
            String myDate = "2024/06/27 23:40:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = sdf.parse(myDate);
            this.timeBaseOffset = date.getTime();
            randString = new ArrayList<>(iterations);
            IntStream.range(0, iterations).forEach(iter -> randString.add("it" + iter + "-" + shortUUID()));
            // @formatter:off
            xlog("XStateInit: timeBaseOffset=" + timeBaseOffset
                    + " iter=" + iterations
                    + " uuid=" + uuid + " randString.size="+ randString.size()
                    + " randString:"+randString
            );
            // @formatter:on
        }
    }

    @Benchmark
    @Measurement(iterations = 2, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void simple(XState xstate) throws InterruptedException {
        Thread.sleep(100);
        long now = System.currentTimeMillis();
        final int iter = xstate.iterations;
        xlog("BenchParamSimple. xstate=" + xstate + " delta=" + (now - xstate.timeBaseOffset) + " iter=" + iter + " x.uuid=" + xstate.uuid
                + " x.randString.size=" + xstate.randString.size() + " x.randString:" + xstate.randString);
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }

    public static String shortUUID() {
        final long id = UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFF;
        return Long.toString(id, 16);
    }
}
