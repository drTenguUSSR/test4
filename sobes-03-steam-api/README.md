# группировка данных используя Java Stream API

## Формулировка задачи

дан список элементов Music(см.класс mil.teng.sobes03.music.Music) - каждый
элемент содержит:

- author - имя автора

- name - название мелодии

см. [код класса](#data-class-music)

## алгоритмы реализации

## <a id="data-class-music" /> класс Music

```java
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
```

## результаты

Text Text Text Text Text Text Text Text Text 
