package mil.teng.sobes03.bench;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import mil.teng.sobes03.music.Music;
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
 * setup console encoding: File/Setting/Editor > General > Console (one drop-down)
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2, jvmArgs = { "-Dfile.encoding=UTF-8", "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, batchSize = 1, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MusicSortTest {
    @Benchmark
    public void viaSteam(Blackhole blackhole, BenchParam param) throws InterruptedException {
        final var musicList = param.allMusic;
        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        dumpInfo("viaSteam", resA);
        Thread.sleep(100);
        blackhole.consume(resA);
    }

    //    @Benchmark
    //    public void viaMap(Blackhole blackhole, BenchParam param) {
    //        final var musicList = param.allMusic;
    //        final Map<String, Set<String>> recalcList = new HashMap<>();
    //        musicList.forEach(mus -> recalcList.merge(mus.getAuthor(), makeSet(mus.getName()), (s1, s2) -> fx(s1, s2)));
    //        dumpInfo("viaMap", recalcList);
    //        blackhole.consume(recalcList);
    //    }

    private Set<String> fx(Set<String> s1, Set<String> s2) {
        s1.addAll(s2);
        return s1;
    }

    private Set<String> makeSet(String name) {
        final HashSet<String> res = new HashSet<>();
        res.add(name);
        return res;
    }

    private void dumpInfo(String prefix, Map<String, Set<String>> allData) {
        xlog("dumpInfo(",prefix,")=[");
        allData.forEach((datA, datB) -> xlog(datA + ": " + String.join(",", datB)));
        xlog("]");
    }

    //@Benchmark
    public void simple(Blackhole blackhole, BenchParam param) throws InterruptedException {
        Thread.sleep(500);
        long now = System.currentTimeMillis();
        xlog("simple called. now=" + now);
        blackhole.consume(param.now + now);
    }

    @State(Scope.Benchmark)
    public static class BenchParam {
        List<Music> allMusic;
        long now = System.currentTimeMillis();

        @Setup(Level.Iteration)
        public void setUp() {
            List<Music> musicList = new ArrayList<Music>(100);
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

            xlog("setup: musicList.size=" + musicList.size());
            this.allMusic = musicList;
        }
    }

    public static void xlog(String... msg) {
        System.out.println(String.join(" ",msg));
    }
}
/** sort-result
 Бах: Бах. silence of winter,Бах. the decline of summer,Бах. the arrival of spring,Бах. take off of autumn
 Бетховен: Бетховен. der Niedergang des Sommers,Бетховен. Abheben vom Herbst,Бетховен. die Ankunft des Frühlings,Бетховен. Stille des Winters
 Шуберт: Шуберт. тишина на зимата,Шуберт. залезът на лятото,Шуберт. пристигането на пролетта,Шуберт. излитане на есента
 Моцарт: упадок лета,приход весны,молчанье зимы,взлет осени
 */

