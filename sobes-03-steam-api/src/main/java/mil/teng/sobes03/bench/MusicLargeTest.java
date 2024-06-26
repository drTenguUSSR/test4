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
 *
 * \@Fork(value = 5, jvmArgs = { "-Xms6G", "-Xmx6G" })
 * \@Warmup(iterations = 10, time = 40, timeUnit = TimeUnit.SECONDS)
 * \@Measurement(iterations = 10, time = 40, timeUnit = TimeUnit.SECONDS)
 * \@Param({ "2000" })
 * => ETA 05:33:20
 *
 * \@Fork(value = 5, jvmArgs = { "-Xms6G", "-Xmx6G" })
 * \@Warmup(iterations = 10, time = 20, timeUnit = TimeUnit.SECONDS)
 * \@Measurement(iterations = 10, time = 20, timeUnit = TimeUnit.SECONDS)
 * \@Param({ "20000" })
 * => ETA 02:46:40
 */

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 5, jvmArgs = { "-Xms6G", "-Xmx6G" })
@Warmup(iterations = 10, time = 20, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 20, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MusicLargeTest {

    @Benchmark
    public void viaStreamGroupA(Blackhole blackhole, BenchParam param) {
        final var resA = SortAlgorithms.makeSortViaStreamGroupA(param.allMusic);
        blackhole.consume(resA);
    }

    @Benchmark
    public void viaStreamGroupB(Blackhole blackhole, BenchParam param) {
        final var resA = SortAlgorithms.makeSortViaStreamGroupB(param.allMusic);
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

    @Benchmark
    public void viaForMap(Blackhole blackhole, BenchParam param) {
        final var resA = SortAlgorithms.makeSortViaForMap(param.allMusic);
        blackhole.consume(resA);
    }

    @State(Scope.Benchmark)
    public static class BenchParam {
        List<Music> allMusic;

        //@Param({ "200", "2000", "20000", "200000", "2000000" })
        //@Param({ "200", "2000000" })
        //@Param({ "200", "2000", "20000", "200000", "2000000","20000000" })
        //max checked - "20 000 000"
        @Param({ "20000" })
        public int maxMelody;

        @Setup(Level.Iteration)
        public void setUp() {
            this.allMusic = SortAlgorithms.generateMusicList(30, maxMelody);
        }
    }
}
