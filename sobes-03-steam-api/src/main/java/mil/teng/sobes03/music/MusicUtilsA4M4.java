package mil.teng.sobes03.music;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author DrTengu, 2024/06
 */
public class MusicUtilsA4M4 {
    public static ArrayList<Music> createList() {
        final var musicList = new ArrayList<Music>();

        musicList.add(new Music(Info.A1, Info.A1_1));
        musicList.add(new Music(Info.A1, Info.A1_2));
        musicList.add(new Music(Info.A2, Info.A2_5));
        musicList.add(new Music(Info.A2, Info.A2_1));
        musicList.add(new Music(Info.A3, Info.A3_2));
        musicList.add(new Music(Info.A2, Info.A2_2));
        musicList.add(new Music(Info.A1, Info.A1_4));
        musicList.add(new Music(Info.A2, Info.A2_3));
        musicList.add(new Music(Info.A2, Info.A2_4));
        musicList.add(new Music(Info.A3, Info.A3_4));
        musicList.add(new Music(Info.A4, Info.A4_1));
        musicList.add(new Music(Info.A3, Info.A3_5));
        musicList.add(new Music(Info.A4, Info.A4_2));
        musicList.add(new Music(Info.A3, Info.A3_1));
        musicList.add(new Music(Info.A3, Info.A3_3));
        musicList.add(new Music(Info.A4, Info.A4_3));
        musicList.add(new Music(Info.A1, Info.A1_3));
        musicList.add(new Music(Info.A4, Info.A4_4));
        return musicList;
    }

    public static class Info {
        public static final String A1 = "Моцарт";
        public static final String A2 = "Бах";
        public static final String A3 = "Бетховен";
        public static final String A4 = "Шуберт";

        public static final Set<String> AllAuthors = Set.of(MusicUtilsA4M4.Info.A1, MusicUtilsA4M4.Info.A2, MusicUtilsA4M4.Info.A3,
                MusicUtilsA4M4.Info.A4);

        public static final String A1_1 = "Моцарт-1. приход весны";
        public static final String A1_2 = "Моцарт-2. упадок лета";
        public static final String A1_3 = "Моцарт-3. взлет осени";
        public static final String A1_4 = "Моцарт-4. молчанье зимы";

        public static final Set<String> musNameA1 = Set.of(MusicUtilsA4M4.Info.A1_1, MusicUtilsA4M4.Info.A1_2, MusicUtilsA4M4.Info.A1_3,
                MusicUtilsA4M4.Info.A1_4);

        public static final String A2_1 = "Бах-1. the arrival of spring";
        public static final String A2_2 = "Бах-2. the decline of summer";
        public static final String A2_3 = "Бах-3. take off of autumn";
        public static final String A2_4 = "Бах-4. silence of winter";
        public static final String A2_5 = "Бах-5. unexpected one";

        public static final Set<String> musNameA2 = Set.of(MusicUtilsA4M4.Info.A2_1, MusicUtilsA4M4.Info.A2_2, MusicUtilsA4M4.Info.A2_3,
                MusicUtilsA4M4.Info.A2_4,MusicUtilsA4M4.Info.A2_5);

        public static final String A3_1 = "Бетховен-1. die Ankunft des Frühlings";
        public static final String A3_2 = "Бетховен-2. der Niedergang des Sommers";
        public static final String A3_3 = "Бетховен-3. Abheben vom Herbst";
        public static final String A3_4 = "Бетховен-4. Stille des Winters";
        public static final String A3_5 = "Бетховен-5. unexpected two";

        public static final Set<String> musNameA3 = Set.of(MusicUtilsA4M4.Info.A3_1, MusicUtilsA4M4.Info.A3_2, MusicUtilsA4M4.Info.A3_3,
                MusicUtilsA4M4.Info.A3_4,MusicUtilsA4M4.Info.A3_5);

        public static final String A4_1 = "Шуберт-1. пристигането на пролетта";
        public static final String A4_2 = "Шуберт-2. залезът на лятото";
        public static final String A4_3 = "Шуберт-3. излитане на есента";
        public static final String A4_4 = "Шуберт-4. тишина на зимата";

        public static final Set<String> musNameA4 = Set.of(MusicUtilsA4M4.Info.A4_1, MusicUtilsA4M4.Info.A4_2, MusicUtilsA4M4.Info.A4_3,
                MusicUtilsA4M4.Info.A4_4);
    }
}
