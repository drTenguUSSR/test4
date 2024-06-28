package mil.teng.sobes03.music;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DrTengu, 2024/06
 */
public class CheckSetEquals {
    @Test
    public void simpleEqualsA() {
        Set<String> setA=new HashSet<>();
        setA.add("aaa");
        setA.add("bbb");
        setA.add("ccc");

        Set<String> setB=new HashSet<>();
        setB.add("aaa");
        setB.add("bbb");
        setB.add("ccc");
        Assertions.assertEquals(setA,setB);
    }

    @Test
    public void simpleEqualsB() {
        Set<String> setA=new HashSet<>(Arrays.asList("aaa","bbb","ccc"));

        Set<String> setB=new HashSet<>();
        setB.add("aaa");
        setB.add("bbb");
        setB.add("ccc");
        Assertions.assertEquals(setA,setB);
    }

    @Test
    public void simpleEqualsC() {
        Set<String> setA=new HashSet<>(Arrays.asList("aaa","bbb","ccc"));
        Set<String> setB=new HashSet<>(Arrays.asList("aaa","bbb","ccc"));
        Assertions.assertEquals(setA,setB);
    }

    @Test
    public void unorderedA() {
        Set<String> setA=new HashSet<>(Arrays.asList("bbb","ccc","aaa"));
        Set<String> setB=new HashSet<>(Arrays.asList("aaa","bbb","ccc"));
        Assertions.assertEquals(setA,setB);
    }

    @Test
    public void unorderedB() {
        Set<String> setA=new HashSet<>(Arrays.asList("bbb","ccc","aaa"));
        Set<String> setB=new HashSet<>(Arrays.asList("ccc","aaa","bbb"));
        Assertions.assertEquals(setA,setB);
    }

    @Test
    public void caseSensitiveA() {
        Set<String> setA=new HashSet<>(Arrays.asList("AAA","bbb","ccc"));
        Set<String> setB=new HashSet<>(Arrays.asList("aaa","bbb","ccc"));
        Assertions.assertNotEquals(setA,setB);
    }

    @Test
    public void caseSensitiveB() {
        Set<String> setA=new HashSet<>(Arrays.asList("aaA","bbb","ccc"));
        Set<String> setB=new HashSet<>(Arrays.asList("aaa","bbb","ccc"));
        Assertions.assertNotEquals(setA,setB);
    }

    @Test
    public void caseSensitiveC() {
        Set<String> setA=new HashSet<>(Arrays.asList("aaa","bBb","ccc"));
        Set<String> setB=new HashSet<>(Arrays.asList("aaa","bbB","ccc"));
        Assertions.assertNotEquals(setA,setB);
    }
}
