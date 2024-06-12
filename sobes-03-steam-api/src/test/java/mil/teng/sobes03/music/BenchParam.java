package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.List;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * @author DrTengu, 2024/06
 */

@State(Scope.Benchmark)
public class BenchParam {

    final List<Music> musicList = new ArrayList<Music>();

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
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }
}
