package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author DrTengu, 2024/06
 */
public class SortAlgorithms {
    /**
     * обработка данных с помощью stream(последовательный) + group
     *
     * @param musicList
     * @return
     */
    public static Map<String, Set<String>> makeSortViaStreamGroupA(List<Music> musicList) {
        final var resA = musicList.stream()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        return resA;
    }

    /**
     * обработка данных с помощью stream(паралельный) + group
     *
     * @param musicList
     * @return
     */
    public static Map<String, Set<String>> makeSortViaStreamGroupB(List<Music> musicList) {
        final var resA = musicList.stream().parallel()
                .collect(Collectors.groupingBy(Music::getAuthor, Collectors.mapping(Music::getName, Collectors.toSet())));
        return resA;
    }

    /**
     * обработка данных с помощью forEach + new HashMap/add
     *
     * @param srcMusic
     * @return
     */
    public static Map<String, Set<String>> makeSortViaEachMapA(List<Music> srcMusic) {
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
    public static Map<String, Set<String>> makeSortViaEachMapB(List<Music> srcMusic) {
        final Map<String, Set<String>> resB = new HashMap<>();
        srcMusic.forEach(music -> {
            //TODO: check if use "map.merge"
            resB.computeIfAbsent(music.getAuthor(), k -> new HashSet<>()).add(music.getName());
        });
        return resB;
    }

    public static Map<String, Set<String>> makeSortViaForMap(List<Music> srcMusic) {
        final Map<String, Set<String>> resB = new HashMap<>();
        final int max = srcMusic.size();
        for (int i1 = 0; i1 < max; i1++) {
            final Music music = srcMusic.get(i1);
            final String auth = music.getAuthor();
            final Set<String> names = resB.get(auth);
            if (names == null) {
                final Set<String> dat = new HashSet<>();
                dat.add(music.getName());
                resB.put(auth, dat);
            } else {
                names.add(music.getName());
            }
        }
        return resB;
    }

    /**
     * Генерация списка мелодий по указанным параметрам
     *
     * @param authorsCount - число авторов
     * @param melodyCount  - число мелодий. Автор выбирается случайно из списка авторов
     *                     число мелодий конкретного автора определяется случайно
     * @return список мелодий
     */
    public static List<Music> generateMusicList(int authorsCount, int melodyCount) {
        Random rand = new Random();
        List<String> authorList = new ArrayList<>(authorsCount);
        List<Music> musicList = new ArrayList<>();

        for (int i1 = 0; i1 < authorsCount; i1++) {
            int n = rand.nextInt(99);
            String author = String.format("auth-%03d", n);
            authorList.add(author);
        }

        for (int i1 = 0; i1 < melodyCount; i1++) {
            final String author = authorList.get(rand.nextInt(authorList.size()));
            final Music mus = new Music(author, "mel-" + UUID.randomUUID().toString());
            musicList.add(mus);
        }
        return musicList;
    }

}
