import com.csf.zagreba.hashmaprealization.OwnHashMapRealization;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class OwnHashMapTest {
    private Map<String, String> instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new OwnHashMapRealization<String, String>();
    }

    @Test
    public void newMapShouldHasZeroSize() throws Exception {
        assertEquals(instance.size(), 0);
    }

    @Test
    public void whenAddOneElementSizeShouldGrowsAccordingly() throws Exception {
        instance.put("key", "value");
        assertEquals(instance.size(), 1);
    }

    @Test
    public void newMapShouldBeEmpty() throws Exception {
        assertTrue(instance.isEmpty());
    }

    @Test
    public void whenAddOneElementMapShouldBeNonEmpty() throws Exception {
        instance.put("key", "value");
        assertFalse(instance.isEmpty());
    }

    @Test
    public void searchForNullKeyShouldBeThrewNullPointerException() throws Exception {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> instance.containsKey(null));
    }

    @Test
    public void searchForKeyWhenKeyIsNotInMapShouldBeNotFoundKey() throws Exception {
        instance.put("key", "value");
        assertFalse(instance.containsKey("0"));
    }

    @Test
    public void searchForKeyWhenKeyIsInMapShouldBeFoundKey() throws Exception {
        instance.put("key", "value");
        assertTrue(instance.containsKey("key"));
    }

    @Test
    public void searchForValueWhenValueIsInMapShouldBeFoundValue() throws Exception {
        instance.put("key", "value");
        assertTrue(instance.containsValue("value"));
    }

    @Test
    public void searchForValueWhenValueIsNotInMapShouldBeNotFoundValue() throws Exception {
        instance.put("key", "value");
        assertFalse(instance.containsValue("0"));
    }

    public void searchForNullValueShouldBeThrewNullPointerException() throws Exception {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> instance.containsValue(null));
    }

    @Test
    public void getValueByKeyWhenKeyIsInMapShouldReturnCorrectValue() throws Exception {
        instance.put("key", "value");
        String expResult = "value";
        String result = instance.get("key");
        assertEquals(expResult, result);
    }

    @Test
    public void getValueByKeyWhenKeyIsNotInMapShouldReturnNullValue() throws Exception {
        instance.put("key", "value");
        String expResult = null;
        String result = instance.get("yek");
        assertEquals(expResult, result);
    }

    public void getValueByKeyWhenKeyIsNullShouldBeThrewNullPointerException() throws Exception {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> instance.get(null));
    }

    @Test
    public void putValueInToHeadOfListOfMapShouldReturnOldValue() throws Exception {
        instance.put("key1", "value1");
        String expResult = "value1";
        String result = instance.put("key1", "value2");
        assertEquals(expResult, result);
    }

    @Test
    public void putValueInToTailOfListOfMapShouldReturnNull() throws Exception {
        String expResult = null;
        String result = instance.put("key", "value");
        assertEquals(expResult, result);
    }


    public void putNullValueShouldBeThrewNullPointerException() throws Exception {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> instance.put(null, "value"));
    }

    @Test
    public void removeValueWhenValuesAreInMapShouldReturnOldValue() throws Exception {
        instance.put("key1", "value1");
        instance.put("key2", "value2");
        instance.put("key3", "value3");

        String expResult = "value2";
        String result = instance.remove("key2");
        assertEquals(expResult, result);
    }

    @Test
    public void removeValueWhenValuesAreNotInMapShouldReturnNull() throws Exception {
        String expResult = null;
        String result = instance.remove("0");
        assertEquals(expResult, result);
    }

    public void removeNullValueShouldBeThrewNullPointerException() throws Exception {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> instance.remove(null));
    }

    @Test
    public void whenAddAllElementsSizeShouldGrowsAccordingly() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        instance.putAll(map);
        assertEquals(3, instance.size());
    }

    @Test
    public void whenClearMapMapShouldHasZeroSize() throws Exception {
        instance.put("key1", "value1");
        instance.put("key2", "value2");
        instance.clear();
        assertEquals(0, instance.size());
    }

    @Test
    public void whenSearchAllKeysInEmptyMapShouldReturnEmptySetOfKeys() throws Exception {
        Set<String> expResult = new HashSet<>();
        Set<String> result = instance.keySet();
        assertEquals(expResult, result);
    }

    @Test
    public void whenSearchAllKeysInMapShouldReturnSetOfKeys() throws Exception {
        instance.put("key1", "value1");
        instance.put("key2", "value2");

        Set<String> expResult = new HashSet<>();
        expResult.add("key1");
        expResult.add("key2");

        assertEquals(expResult, instance.keySet());
    }

    @Test
    public void whenSearchAllValuesInEmptyMapShouldReturnEmptySetOfValues() throws Exception {
        Collection<String> expResult = new HashSet<>();
        Collection<String>  result = instance.keySet();
        assertEquals(expResult, result);
    }

    @Test
    public void whenSearchAllValuesInMapShouldReturnSetOfValues() throws Exception {
        instance.put("key1", "value1");
        instance.put("key2", "value2");

        Collection<String> expResult = new ArrayList<>();
        expResult.add("value1");
        expResult.add("value2");

        assertEquals(expResult, instance.values());
    }

    @Test
    public void whenSearchAllKeysAndValuesShouldRuturnSetOfKeysAndValues() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        instance.put(key1, value1);
        instance.put(key2, value2);

        Set<Map.Entry<String, String>> expResult = new LinkedHashSet<>();
        expResult.add(new AbstractMap.SimpleEntry<String, String>(key1, value1));
        expResult.add(new AbstractMap.SimpleEntry<String, String>(key2, value2));

        assertEquals(expResult, instance.entrySet());
    }

    @Test
    public void printMapShouldReturnFormatStringOfKeysAndValuesOfMap() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        instance.put(key1, value1);
        instance.put(key2, value2);

        int index1 = key1.hashCode() % 100;
        int index2 = key2.hashCode() % 100;

        String expResult = "{";
        expResult += (index1 < index2) ? key1 + "=" + value1 + ", " : key2 + "=" + value2 + ", ";
        expResult += (index1 < index2) ? key2 + "=" + value2 : key1 + "=" + value1;
        expResult += "}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
