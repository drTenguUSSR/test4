package mil.teng.sobes03.music;

import java.util.List;
import java.util.Map;

/**
 * @author DrTengu, 2024/06
 */
public class GenerateMultiAuthMultiMus {
    private static final int AUTHORS_COUNT = 2;

    public static void main(String[] args) {
        xlog("AppGen started");
        //final List<Music> musicList = Utils.generateMusicList(3, 25);
        final List<Music> musicList = Utils.generateMusicList(30, 2500);

        musicList.forEach(mus -> xlog("music: " + mus.getAuthor() + ", " + mus.getName()));

        final Map<String, Integer> res = Utils.musicRecalc(musicList);
        xlog("musicList.size=" + musicList.size());

        res.forEach((resK, resV) -> xlog("auth:" + resK + " count=" + resV));
        final Integer recalcTotal = res.entrySet().stream().map(ent -> ent.getValue()).reduce(0, (subtotal, element) -> subtotal + element);
        xlog("recalcTotal=" + recalcTotal);
    }

    public static void xlog(String msg) {
        System.out.println(msg);
    }
}
