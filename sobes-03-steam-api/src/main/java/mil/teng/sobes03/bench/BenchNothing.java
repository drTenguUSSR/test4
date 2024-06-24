package mil.teng.sobes03.bench;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author DrTengu, 2024/06
 */
public class BenchNothing {
    public static void main(String[] args) throws Exception {
        xlog("BenchNothing/03");
        //org.openjdk.jmh.Main.main(new String[] { "BenchNothing" });
        Options opt = new OptionsBuilder().include(BenchNothing.class.getSimpleName()).build();
        new Runner(opt).run();
    }

    @Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, batchSize = 1)
    @Fork(value = 2)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void execNothing() throws InterruptedException {
        Thread.sleep(300);
        xlog("execNothing called. this=" + this.toString());
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }
}
