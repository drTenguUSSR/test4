package mil.teng.sobes03.music;

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
        final var musicList = MusicUtilsA4M4.createList();

        xlog("musicList=[");
        musicList.forEach(it -> xlog(it.toString()));
        xlog("]");

        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        xlog("resA=[");
        resA.forEach((key, val) -> xlog(key + ":" + "val.size=" + val.size() + ", " + String.join("|", val)));
        xlog("]");


        final Map<String, Set<String>> resB = new HashMap<>();
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

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}

