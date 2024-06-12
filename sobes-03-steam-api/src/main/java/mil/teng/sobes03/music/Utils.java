package mil.teng.sobes03.music;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DrTengu, 2024/06
 */
public class Utils {

    public static Map<String, Integer> musicRecalc(List<Music> musicList) {
        final Map<String, Integer> recalcList = new HashMap<>();
        musicList.forEach(mus -> recalcList.merge(mus.getAuthor(), 1, Integer::sum));
        return recalcList;
    }
}
