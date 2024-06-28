package mil.teng.sobes03.debug;

import java.util.concurrent.TimeUnit;
import mil.teng.sobes03.music.Utils;
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
public class DebugStateParam {

    @Benchmark
    @Measurement(iterations = 2, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void simple(XState xstate) throws InterruptedException {
        Thread.sleep(100);
        long now = System.currentTimeMillis();
        xlog("simple: xstate.maxMelody="+xstate.maxMelody);

    }

    @State(Scope.Benchmark)
    public static class XState {
        @Param({ "200", "2000" })
        public int maxMelody;

        @Setup(Level.Trial)
        public void setUp() {
            xlog("benchSetup. maxMelody"+maxMelody);
        }
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}
