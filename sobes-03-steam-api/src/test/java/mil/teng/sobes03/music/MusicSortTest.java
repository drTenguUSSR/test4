package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
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
public class MusicSortTest {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(new String[] { "MusicSortTest" });
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }

    //    @Benchmark
    //    @BenchmarkMode(Mode.AverageTime)
    //    @Warmup(iterations = 1) //10 | default 5 x 10sec
    //@Measurement(iterations = 3, batchSize = 3) //iterations = 100, batchSize = 10 | default 5 x 10sec
    public void workA(Blackhole blackhole, BenchParam param) {
        final var musicList = param.musicList;
        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        blackhole.consume(resA);
    }

    @Warmup(iterations = 2, time = 2) //Warmup: 2 iterations, 2 s each
    @Measurement(iterations = 1, batchSize = 1) //Measurement: 1 iterations, 10 s each
    @Fork(value = 2, jvmArgs = { "-server", "-Xms2G", "-Xmx2G" }) //Fork: 1 of 2; //default: Fork: 1 of 5
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void prepInfo(Blackhole blackhole, BenchParam param) {
        blackhole.consume(param);
    }

    @State(Scope.Benchmark)
    public static class BenchParam {

        final List<Music> musicList = new ArrayList<Music>();
        final AtomicLong countCall = new AtomicLong(0);

        @Setup(Level.Invocation)
        public void setUp() {
            musicList.add(new Music("Моцарт", "приход весны"));
            musicList.add(new Music("Моцарт", "упадок лета"));
            musicList.add(new Music("Бах", "Бах. the arrival of spring"));
            musicList.add(new Music("Бетховен", "Бетховен. der Niedergang des Sommers"));
            musicList.add(new Music("Бах", "Бах. the decline of summer"));
            musicList.add(new Music("Моцарт", "молчанье зимы"));
            musicList.add(new Music("Бах", "Бах. take off of autumn"));
            musicList.add(new Music("Бах", "Бах. silence of winter"));
            musicList.add(new Music("Бетховен", "Бетховен. Stille des Winters"));
            musicList.add(new Music("Шуберт", "Шуберт. пристигането на пролетта"));
            musicList.add(new Music("Шуберт", "Шуберт. залезът на лятото"));
            musicList.add(new Music("Бетховен", "Бетховен. die Ankunft des Frühlings"));
            musicList.add(new Music("Бетховен", "Бетховен. Abheben vom Herbst"));
            musicList.add(new Music("Шуберт", "Шуберт. излитане на есента"));
            musicList.add(new Music("Моцарт", "взлет осени"));
            musicList.add(new Music("Шуберт", "Шуберт. тишина на зимата"));

            //final Map<String, Integer> res = Utils.musicRecalc(musicList);
            //xlog("musicList.size="+musicList.size());
            //res.forEach((resK,resV) -> xlog("auth:"+resK+" count="+resV));
            //xlog("ts(" + System.currentTimeMillis() + ") musicList.size=" + musicList.size());
            final long cnt = countCall.incrementAndGet();
            xlog("ts(" + System.currentTimeMillis() + ") called:" + cnt + "," + this);
        }
    }

}

