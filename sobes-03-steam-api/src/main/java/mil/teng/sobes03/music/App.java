package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author DrTengu, 2024/06
 */
public class App {
    public static void main(String[] args) {
        xlog("Test App/02");
        final var musicList = getMusicList();

        xlog("musicList=[");
        musicList.forEach(it -> xlog(it.toString()));
        xlog("]");

        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        xlog("resA=[");
        resA.forEach((key, val) -> xlog(key + ":" + "val.size=" + val.size() + ", " + String.join("|", val)));
        xlog("]");


        final Map<String, Set<String>> resB = new HashMap<String, Set<String>>();
        musicList.forEach(music -> {
            final Set<String> names = resB.get(music.getAuthor());
            if (names == null) {
                final var dat=new HashSet<String>();
                dat.add(music.getName());
                resB.put(music.getAuthor(),dat );
            } else {
                names.add(music.getName());
            }
        });
        xlog("resB=[");
        resB.forEach((key, val) -> xlog(key + ":" + "val.size=" + val.size() + ", " + String.join("|", val)));
        xlog("]");

    }

    private static ArrayList<Music> getMusicList() {
        final var musicList = new ArrayList<Music>();

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
        return musicList;
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }
}

