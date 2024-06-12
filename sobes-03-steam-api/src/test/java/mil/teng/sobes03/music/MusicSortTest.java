package mil.teng.sobes03.music;

import java.util.stream.Collectors;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

/**
 * @author DrTengu, 2024/06
 */
public class MusicSortTest {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1) //10 | default 5 x 10sec
    //@Measurement(iterations = 3, batchSize = 3) //iterations = 100, batchSize = 10 | default 5 x 10sec
    public void init(Blackhole blackhole, BenchParam param) {
        final var musicList = param.musicList;
        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        blackhole.consume(resA);
    }
}

