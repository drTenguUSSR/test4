package mil.teng.sobes03.bench;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import mil.teng.sobes03.music.Music;
import mil.teng.sobes03.music.MusicUtilsA4M4;
import mil.teng.sobes03.music.SortAlgorithms;
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
import org.openjdk.jmh.infra.Blackhole;

/**
 * @author DrTengu, 2024/06
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, jvmArgs = { "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 1, time = 280, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 1, batchSize = 2, time = 800, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MusicA4M4SortWithPrintTest {
    @Benchmark
    public void viaSteam(Blackhole blackhole, BenchParam param) throws InterruptedException {
        final var resA = SortAlgorithms.makeSortViaStreamGroup(param.allMusic);
        dumpInfo("viaSteam", resA);
        Thread.sleep(70);
        blackhole.consume(resA);
    }

    //@Benchmark
    public void simple() throws InterruptedException {
        xlog("simple: "+System.currentTimeMillis());
        Thread.sleep(100);
    }

    private static void dumpInfo(String prefix, Map<String, Set<String>> allData) {
        xlog("dumpInfo(", prefix, ")=[");
        allData.forEach((datA, datB) -> xlog(datA + ": " + String.join(",", datB)));
        xlog("]");
    }

    @State(Scope.Benchmark)
    public static class BenchParam {
        List<Music> allMusic;
        long now = System.currentTimeMillis();

        @Setup(Level.Iteration)
        public void setUp() {
            List<Music> musicList = MusicUtilsA4M4.createList();
            xlog("setup: musicList.size=" , Integer.toString(musicList.size()));
            this.allMusic = musicList;
        }
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}


