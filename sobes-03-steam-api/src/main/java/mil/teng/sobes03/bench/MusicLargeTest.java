package mil.teng.sobes03.bench;

import java.util.List;
import java.util.concurrent.TimeUnit;
import mil.teng.sobes03.music.Music;
import mil.teng.sobes03.music.SortAlgorithms;
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
import org.openjdk.jmh.infra.Blackhole;

/**
 * @author DrTengu, 2024/06
 */

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 5, jvmArgs = { "-Xms6G", "-Xmx6G" })
@Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MusicLargeTest {

    @Benchmark
    public void viaSteam(Blackhole blackhole, BenchParam param) {
        final var resA = SortAlgorithms.makeSortViaStreamGroup(param.allMusic);
        blackhole.consume(resA);
    }

    @Benchmark
    public void viaEachMapA(Blackhole blackhole, BenchParam param) {
        final var resA = SortAlgorithms.makeSortViaEachMapA(param.allMusic);
        blackhole.consume(resA);
    }

    @Benchmark
    public void viaEachMapB(Blackhole blackhole, BenchParam param) {
        final var resA = SortAlgorithms.makeSortViaEachMapB(param.allMusic);
        blackhole.consume(resA);
    }

    @State(Scope.Benchmark)
    public static class BenchParam {
        List<Music> allMusic;

        @Param({ "200", "2000", "20000", "200000", "2000000" })
        //@Param({ "200", "2000000" })
        public int maxMelody;

        @Setup(Level.Iteration)
        public void setUp() {
            this.allMusic = SortAlgorithms.generateMusicList(30, maxMelody);
        }
    }
}
