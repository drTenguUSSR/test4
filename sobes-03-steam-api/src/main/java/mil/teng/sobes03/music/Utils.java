package mil.teng.sobes03.music;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author DrTengu, 2024/06
 */
public class Utils {
    /**
     * Перерасчет список мелодий в карту:
     *  ключ - автор
     *  значение - число мелодий автора
     * @param musicList
     * @return
     */
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

    public static String shortUUID() {
        final long id = UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFF;
        return Long.toString(id, 16);
    }

    public static String lastDot(String param) {
        final int lastIndex = param.lastIndexOf('.');
        if (lastIndex == -1) {
            return param;
        }
        return param.substring(lastIndex+1);
    }

}
