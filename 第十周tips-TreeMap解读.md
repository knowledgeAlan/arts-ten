# TreeMap理解

## 1.环境

jdk:1.8

###1.1介绍

本文将介绍java中集合框架中实现`Map`接口`TreeMap` ，`TreeMap `实现`map`接口提供根据元素`key`自然排序或使用自定义排序规则来存储元素，之前文章有介绍[HashMap](https://www.jianshu.com/p/df503a2662a8) 和 [LinkedHashMap](https://www.baeldung.com/java-linked-hashmap) ，可以对比来查看有些地方是相似，建议查看本文之前阅读之前介绍文章

##2.TreeMap默认排序

`TreeMap`元素默认排序是按照自然排序，对于`Integer `是按照升序，对于字符按照字母顺序，下面例子：

```java
@Test
public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect() {
    TreeMap<Integer, String> map = new TreeMap();
    map.put(3, "val");
    map.put(2, "val");
    map.put(1, "val");
    map.put(5, "val");
    map.put(4, "val");
 
    assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
}
```

上面增加key是无序，但是返回key的`set`是有升序，同时使用字符串，存储是自然序-字母顺序

下面是例子：

```java
@Test
public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect2() {
    TreeMap<String, String> map = new TreeMap();
    map.put("c", "val");
    map.put("b", "val");
    map.put("a", "val");
    map.put("e", "val");
    map.put("d", "val");
 
    assertEquals("[a, b, c, d, e]", map.keySet().toString());
}
```

`TreeMap` 不像 hash map 和linked hash map，不需要hash来定位元素位置，因为没有使用数组来存储元素

## 3.TreeMap自定义排序

如果自然排序不能满足需求，初始化时候可以自定义排序规则，下面例子使用`Integer`降序排列：

```java
@Test
public void givenTreeMap_whenOrdersEntriesByComparator_thenCorrect() {
    TreeMap<Integer, String> map = 
      new TreeMap(Comparator.reverseOrder());
    map.put(3, "val");
    map.put(2, "val");
    map.put(1, "val");
    map.put(5, "val");
    map.put(4, "val");
         
    assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
}
```

`hashMap`不能保证key排序存储和出现相同排序，但是`TreeMap` 可以保证key总是有序性存储

## 4 .TreeMap重要排序

现在已经知道TreeMap存储元素是有序，因为`TreeMap`属性，可以查询最大，最小，查找key小于或者大于固定值，等等，下面介绍小部分情况例子：

```java
@Test
public void givenTreeMap_whenPerformsQueries_thenCorrect() {
    TreeMap<Integer, String> map = new TreeMap();
    map.put(3, "val");
    map.put(2, "val");
    map.put(1, "val");
    map.put(5, "val");
    map.put(4, "val");
         
    Integer highestKey = map.lastKey();
    Integer lowestKey = map.firstKey();
    Set<Integer> keysLessThan3 = map.headMap(3).keySet();
    Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();
 
    assertEquals(new Integer(5), highestKey);
    assertEquals(new Integer(1), lowestKey);
    assertEquals("[1, 2]", keysLessThan3.toString());
    assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
}
```

## 5.TreeMap内部实现

`TreeMap`实现`NavigableMap ` 接口和内部工作规则使用红黑树：

```java
public class TreeMap<K,V>
    extends AbstractMap<K,V>
    implements NavigableMap<K,V>, Cloneable, java.io.Serializable
```

红黑树超过了本文介绍访问，然而这些key存储是有序

首先：红黑数保证元素数据结构一致性，可以想象是棵芒果树在天空下，树上分支向下成长，树的根节点元素是第一个节点，从根节点出发，任何元素左节点小于中间节点，右节点大于中间节点，定义大于或者小于自然排序或者自定义排序初始化时候，这个规则保证`TreeMap` 元素总是有序和可以预测顺序

第二：红黑树是自平衡树，以上属性保证基本操作，例如：搜索 、获取、增加、和删除时间复杂度是O(log n),在增加和删除过程中，会改变树形状，树的长分支搜索需要时间比较长，短分支需要时间短， `TreeMap`自平衡保证红黑树特性，不会使上面情况发生，因此考虑到使用红黑树设计，对每次删除和插入，最大树高度被维持需要时间复杂度O(log n)，例如 树自平衡，

上面hash map 和linked hash map，tree map不是线程安全，因此多线程环境处理方式和之前讲相似

## 6.正确选择Map

之前介绍[HashMap](https://www.jianshu.com/p/df503a2662a8) 和 [LinkedHashMap](https://www.baeldung.com/java-linked-hashmap) 实现，现在是`TreeMap` ，很重要概况下它们三者之区别：

`HashMap` 适合一般场景，实现提供存储和 获取操作，缺点是存放元素是无序和，在排序场景 性能低下，需要遍历所有元素来进行排序

 `TreeMap` 完全自己控制key` 排序，在另一方面，性能会比其他性能差

`TreeMap`在没有引起性能问题情况下，linked hash map提高hash map排序问题

## 7.总结

本文讨论`java` 中`TreeMap` 和内部实现,因此最后一系列文章中讨论共同`map` 接口实现，简单讨论

之间优缺点使用情况



