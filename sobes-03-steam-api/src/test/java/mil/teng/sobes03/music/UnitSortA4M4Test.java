package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DrTengu, 2024/06
 */
public class UnitSortA4M4Test {
    @Test
    public void checkCorrectInput() {
        final ArrayList<Music> srcMusic = MusicUtilsA4M4.createList();
        // количество всех мелодий - 19
        Assertions.assertEquals(19, srcMusic.size());
        // количество авторов - 4
        Assertions.assertEquals(4, srcMusic.stream().map(mus -> mus.getAuthor()).distinct().count());

        // количество мелодий для каждого автора фиксировано
        Assertions.assertEquals(4, srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A1.equals(mus.getAuthor())).count());
        Assertions.assertEquals(6, srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A2.equals(mus.getAuthor())).count());
        Assertions.assertEquals(5, srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A3.equals(mus.getAuthor())).count());
        Assertions.assertEquals(4, srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A4.equals(mus.getAuthor())).count());

        Set<String> allMel;
        allMel = srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A1.equals(mus.getAuthor())).map(mus -> mus.getName())
                .collect(Collectors.toSet());
        allMel.removeAll(List.of(MusicUtilsA4M4.Info.A1_1, MusicUtilsA4M4.Info.A1_2, MusicUtilsA4M4.Info.A1_3, MusicUtilsA4M4.Info.A1_4));
        Assertions.assertEquals(0, allMel.size());

        allMel = srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A2.equals(mus.getAuthor())).map(mus -> mus.getName())
                .collect(Collectors.toSet());
        allMel.removeAll(List.of(MusicUtilsA4M4.Info.A2_1, MusicUtilsA4M4.Info.A2_2, MusicUtilsA4M4.Info.A2_3, MusicUtilsA4M4.Info.A2_4,
                MusicUtilsA4M4.Info.A2_5,MusicUtilsA4M4.Info.A2_6));
        Assertions.assertEquals(0, allMel.size());

        allMel = srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A3.equals(mus.getAuthor())).map(mus -> mus.getName())
                .collect(Collectors.toSet());
        allMel.removeAll(List.of(MusicUtilsA4M4.Info.A3_1, MusicUtilsA4M4.Info.A3_2, MusicUtilsA4M4.Info.A3_3, MusicUtilsA4M4.Info.A3_4,
                MusicUtilsA4M4.Info.A3_5));
        Assertions.assertEquals(0, allMel.size());

        allMel = srcMusic.stream().filter(mus -> MusicUtilsA4M4.Info.A4.equals(mus.getAuthor())).map(mus -> mus.getName())
                .collect(Collectors.toSet());
        allMel.removeAll(List.of(MusicUtilsA4M4.Info.A4_1, MusicUtilsA4M4.Info.A4_2, MusicUtilsA4M4.Info.A4_3, MusicUtilsA4M4.Info.A4_4));
        Assertions.assertEquals(0, allMel.size());
    }

    @Test
    public void checkViaStreamGroup() {
        final ArrayList<Music> srcMusic = MusicUtilsA4M4.createList();
        final Map<String, Set<String>> resA = Utils.makeSortViaStreamGroup(srcMusic);
        xlog("checkViaStreamGroup-resA:[");
        Utils.dumpMap(resA);
        xlog("]");
        validateResult(resA);
    }

    @Test
    public void checkViaEachMapA() {
        final ArrayList<Music> srcMusic = MusicUtilsA4M4.createList();
        final Map<String, Set<String>> resA = Utils.makeSortViaEachMapA(srcMusic);
        xlog("checkViaEachMapA-resA:[");
        Utils.dumpMap(resA);
        xlog("]");
        validateResult(resA);
    }

    @Test
    public void checkViaEachMapB() {
        final ArrayList<Music> srcMusic = MusicUtilsA4M4.createList();
        final Map<String, Set<String>> resA = Utils.makeSortViaEachMapB(srcMusic);
        xlog("checkViaEachMapB-resA:[");
        Utils.dumpMap(resA);
        xlog("]");
        validateResult(resA);
    }

    private void validateResult(final Map<String, Set<String>> srcA) {
        final Set<String> authors = srcA.keySet();
        Assertions.assertEquals(4, authors.size());
        Assertions.assertEquals(0, authors.stream().filter(auth -> !MusicUtilsA4M4.Info.AllAuthors.contains(auth)).count());

        Set<String> musList;
        musList = srcA.get(MusicUtilsA4M4.Info.A1);
        Assertions.assertEquals(4, musList.size());
        Assertions.assertEquals(0, musList.stream().filter(musName -> !MusicUtilsA4M4.Info.musNameA1.contains(musName)).count(),
                "musList:" + musList);

        musList = srcA.get(MusicUtilsA4M4.Info.A2);
        Assertions.assertEquals(6, musList.size(), "musList:" + musList);
        Assertions.assertEquals(0, musList.stream().filter(musName -> !MusicUtilsA4M4.Info.musNameA2.contains(musName)).count(),
                "musList:" + musList);

        musList = srcA.get(MusicUtilsA4M4.Info.A3);
        Assertions.assertEquals(5, musList.size(), "musList:" + musList);
        Assertions.assertEquals(0, musList.stream().filter(musName -> !MusicUtilsA4M4.Info.musNameA3.contains(musName)).count(),
                "musList:" + musList);

        musList = srcA.get(MusicUtilsA4M4.Info.A4);
        Assertions.assertEquals(4, musList.size(), "musList:" + musList);
        Assertions.assertEquals(0, musList.stream().filter(musName -> !MusicUtilsA4M4.Info.musNameA4.contains(musName)).count(),
                "musList:" + musList);

    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}
