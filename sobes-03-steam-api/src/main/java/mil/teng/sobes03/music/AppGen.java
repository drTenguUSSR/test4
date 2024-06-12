package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author DrTengu, 2024/06
 */
public class AppGen {
    private static final int AUTHORS_COUNT = 2;

    public static void main(String[] args) {
        xlog("AppGen started");
        Random rand = new Random();
        List<String> authorList = new ArrayList<>(AUTHORS_COUNT);
        List<Music> musicList = new ArrayList<>();

        for (int i1 = 0; i1 < AUTHORS_COUNT; i1++) {
            int n = rand.nextInt(99);
            String author = String.format("auth-%03d", n);
            authorList.add(author);
        }

        for (int i1 = 0; i1 < 15; i1++) {
            final String author = authorList.get(rand.nextInt(authorList.size()));
            final Music mus = new Music(author, "mel-" + UUID.randomUUID().toString());
            musicList.add(mus);
        }

        musicList.forEach(mus -> xlog("music: " + mus.getAuthor() + ", " + mus.getName()));

        final Map<String, Integer> res = Utils.musicRecalc(musicList);
        xlog("musicList.size="+musicList.size());
        res.forEach((resK,resV) -> xlog("auth:"+resK+" count="+resV));

    }


    public static void xlog(String msg) {
        System.out.println(msg);
    }
}
