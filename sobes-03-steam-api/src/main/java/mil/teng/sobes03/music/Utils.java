package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author DrTengu, 2024/06
 */
public class Utils {

    /**
     * обработка данных с помощью stream + group
     *
     * @param musicList
     * @return
     */
    public static Map<String, Set<String>> makeSortViaStreamGroup(List<Music> musicList) {
        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        return resA;
    }

    /**
     * обработка данных с помощью forEach + new HashMap/add
     *
     * @param srcMusic
     * @return
     */
    public static Map<String, Set<String>> makeSortViaEachMapA(ArrayList<Music> srcMusic) {
        final Map<String, Set<String>> resB = new HashMap<>();
        srcMusic.forEach(music -> {
            final Set<String> names = resB.get(music.getAuthor());
            if (names == null) {
                final var dat = new HashSet<String>();
                dat.add(music.getName());
                resB.put(music.getAuthor(), dat);
            } else {
                names.add(music.getName());
            }
        });
        return resB;
    }

    /**
     * обработка данных с помощью forEach + new HashMap/computeIfAbsent
     *
     * @param srcMusic
     * @return
     */
    public static Map<String, Set<String>> makeSortViaEachMapB(ArrayList<Music> srcMusic) {
        final Map<String, Set<String>> resB = new HashMap<>();
        srcMusic.forEach(music -> {
            //TODO: check if use "map.merge"
            resB.computeIfAbsent(music.getAuthor(), k -> new HashSet<>()).add(music.getName());
        });
        return resB;
    }

    public static Map<String, Integer> musicRecalc(List<Music> musicList) {
        final Map<String, Integer> recalcList = new HashMap<>();
        musicList.forEach(mus -> recalcList.merge(mus.getAuthor(), 1, Integer::sum));
        return recalcList;
    }

    public static void dumpMap(Map<String, Set<String>> resA) {
        resA.forEach((key, val) -> xlog(key + "(" + val.size() + "): " + String.join("|", val)));
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }

}
