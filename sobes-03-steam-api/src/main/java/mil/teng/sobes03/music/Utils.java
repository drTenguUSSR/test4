package mil.teng.sobes03.music;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author DrTengu, 2024/06
 */
public class Utils {

    public static Map<String, Integer> musicRecalc(List<Music> musicList) {
        final Map<String, Integer> recalcList = new HashMap<>();
        musicList.forEach(mus -> recalcList.merge(mus.getAuthor(), 1, Integer::sum));
        return recalcList;
    }

    public static Map<String, Set<String>> makeSortViaStream(List<Music> musicList) {
        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        return resA;
    }
}
