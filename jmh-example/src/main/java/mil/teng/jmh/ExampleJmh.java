/**
 * @author DrTengu, 2024/06
 */

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
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * info:
 * https://jenkov.com/tutorials/java-performance/jmh.html
 * https://medium.com/@truongbui95/jmh-java-microbenchmark-harness-tests-in-java-applications-f607f00f536d
 * <p>
 * fat-jar
 * https://stackoverflow.com/questions/16222748/building-a-fat-jar-using-maven
 * <p>
 * using @Param
 * https://www.baeldung.com/java-microbenchmark-harness
 */

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class ExampleJmh {
    @State(Scope.Benchmark)
    public static class XState {
        private long initOffset;

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
    public void sleep300msA(XState xstate) throws InterruptedException {
        Thread.sleep(300);
        long delta = System.currentTimeMillis() - xstate.initOffset;
        xlog("sleep300msA. this=" + lastDot(this.toString()) + " delta=" + delta + " xstate=" + lastDot(xstate.toString()));
    }

    private String lastDot(String param) {
        final int lastIndex = param.lastIndexOf('.');
        if (lastIndex == -1) {
            return param;
        }
        return param.substring(lastIndex+1);
    }

    //@Benchmark
    @Measurement(iterations = 1, batchSize = 1, time = 100, timeUnit = TimeUnit.MILLISECONDS)
    public void sleep50ms(XState xstate) throws InterruptedException {
        Thread.sleep(50);
        long now = System.currentTimeMillis();
        xlog("ExampleJmh-dontRun. this=" + this.toString() + " xstate=" + xstate);
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }

}
