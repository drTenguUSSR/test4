package mil.teng.sobes03.music;

/**
 * @author DrTengu, 2024/06
 */
public final class Music {
    private final String author;
    private final String name;

    public Music(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Music{" + "author='" + author + '\'' + ", name='" + name + '\'' + '}';
    }
}
