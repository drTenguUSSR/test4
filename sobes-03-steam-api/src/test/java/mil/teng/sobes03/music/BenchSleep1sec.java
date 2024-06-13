package mil.teng.sobes03.music;

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
public class BenchSleep1sec {
    public static void main(String[] args) throws Exception {
        simple1sec();
        org.openjdk.jmh.Main.main(new String[] { "BenchSleep1sec" });
    }




    //main-long
    //@Warmup(iterations = 10, time = 5)//iterations = 1, time=15 //10 | default 5 x 10sec
    //@Measurement(iterations = 1, batchSize = 1) //iterations = 100, batchSize = 10 | default 5 x 10sec

    //special-fast
    @Warmup(iterations = 2, time = 2) //Warmup: 2 iterations, 2 s each
    @Measurement(iterations = 1, batchSize = 1) //Measurement: 1 iterations, 10 s each
    @Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"}) //Fork: 1 of 2; //default: Fork: 1 of 5

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void execFast400ms() throws InterruptedException {
        Thread.sleep(400);
    }

    @Warmup(iterations = 2, time = 2) //Warmup: 2 iterations, 2 s each
    @Measurement(iterations = 1, batchSize = 1) //Measurement: 1 iterations, 10 s each
    @Fork(value = 2, jvmArgs = {"-server","-Xms2G", "-Xmx2G"}) //Fork: 1 of 2; //default: Fork: 1 of 5
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void execFast200ms() throws InterruptedException {
        Thread.sleep(200);
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }

    public static void simple1sec() throws InterruptedException {
        final int infoMs = 400;
        final long beg1 = System.nanoTime();
        final long beg2 = System.currentTimeMillis();
        Thread.sleep(400);
        final long end1 = System.nanoTime();
        final long end2 = System.currentTimeMillis();
        xlog("simple1sec: infoMs=" + infoMs);
        xlog("- result-ns=" + (end1 - beg1) + " ns");
        xlog("- result-ms=" + (end2 - beg2) + " ms");
    }
}
