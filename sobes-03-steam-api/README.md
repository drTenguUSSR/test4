# группировка данных используя Java Stream API

## Формулировка задачи

дан список элементов Music(см.класс mil.teng.sobes03.music.Music) - каждый
элемент содержит:

- author - имя автора
- name - название мелодии

см. [код класса](#data-class-music)

## вывод

при больших объемах данных и простом алгоритме обработки, использование
Stream замедляет работу.

## <a id="sort-algorithms" />алгоритмы реализации

Было реализовано пять алгоритмов. полный код см. в mil.teng.sobes03.music.SortAlgorithms

кратко:

- makeSortViaStreamGroupA - исходный список превращается в Stream, группируется
    через groupingBy
- makeSortViaStreamGroupB - идентично makeSortViaStreamGroupA, но Stream
    распараллеливается
- makeSortViaEachMapA - исходный массив перебирается через forEach. Каждый
    элемент оценивается отдельно и складывается во внешний HashMap.
    computeIfAbsent не применяется
- makeSortViaEachMapB - исходный массив перебирается через forEach. Каждый
    элемент оценивается отдельно и складывается во внешний HashMap.
    computeIfAbsent применяется
- makeSortViaForMap - исходный массив перебирается через цикл for(i1=...).
    Каждый элемент оценивается отдельно и складывается во внешний HashMap.
    computeIfAbsent не применяется. Максимально прямолинейный код

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

оригинальные файлы данных JMH-тестов см. в папке [reports](reports)

визуализация через [https://jmh.morethan.io/](https://jmh.morethan.io/)

### MusicLargeTest-20kk

ключевые параметры:

- Warmup: 3 iterations, 5 s each
- Measurement: 3 iterations, 5 s each
- maxMelody=200,20000000
- total-time=00:53:41

![MusicLargeTest-20kk.png](reports/MusicLargeTest-20kk.png)

для 20'000'000 элементов

самый быстрый алгоритм (f) - viaEachMapA, 5093,20 ms

самый медленный алгоритм (s)- viaStreamGroupB, 6273,93 ms

потери (s-f)*100/f = 23%

### MusicLargeTest-A

- Warmup: 5 iterations, 15 s each
- Measurement: 5 iterations, 15 s each
- maxMelody=200,2'000,20'000,200'000,2'000'000,20'000'000
- total-time=07:04:58

![MusicLargeTest-A-1.png](reports/MusicLargeTest-A-1.png)
![MusicLargeTest-A-2.png](reports/MusicLargeTest-A-2.png)

для 20'000'000 элементов

самый быстрый алгоритм - viaForMap, 3624,38 ms

самый медленный алгоритм - viaStreamGroupB, 5296,65 ms

потери = 46%

### MusicLargeTest-B

- Warmup: 7 iterations, 30 s each
- Measurement: 7 iterations, 30 s each
- maxMelody=200'000
- total-time=02:55:42

![MusicLargeTest-B.png](reports/MusicLargeTest-B.png)

самый быстрый алгоритм - viaEachMapB. 15,86 ms

самый медленный алгоритм - viaStreamGroupB, 23,36 ms

потери=47%
