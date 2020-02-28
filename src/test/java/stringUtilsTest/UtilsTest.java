package stringUtilsTest;


import offer66.A;
import org.junit.Assert;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class UtilsTest {

    /**
     * isEmpty()判断对象是否为空/空字符串
     */
    public static void isEmptyTest(){
        String str1 = null;
        String str2 = "";
        Assert.assertEquals(StringUtils.isEmpty(str1),true);
        Assert.assertEquals(StringUtils.isEmpty(str2),true);
//        if(StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)){
//            System.out.println("对象为空");
//        }
    }

    /**
     * hasLength()判断字符串长度是否大于0
     */
    public static void isHasLength(){
        String str1 = null;
        String str2 = "";
        String str3 = " ";
        String str4 = "hello";
        Assert.assertEquals(StringUtils.hasLength(str1),false);
        Assert.assertEquals(StringUtils.hasLength(str2),false);
        Assert.assertEquals(StringUtils.hasLength(str3),true);
        Assert.assertEquals(StringUtils.hasLength(str4),true);
    }

    /**
     *hasText()判断字符串长度大于0，除去空字符串情况
     */
    public static void isHasText(){
        String str1 = null;
        String str2 = "";
        String str3 = " ";
        String str4 = "hello";
        String str5 = " hello ";
        Assert.assertEquals(StringUtils.hasText(str1),false);
        Assert.assertEquals(StringUtils.hasText(str2),false);
        Assert.assertEquals(StringUtils.hasText(str3),false);
        Assert.assertEquals(StringUtils.hasText(str4),true);
        Assert.assertEquals(StringUtils.hasText(str5),true);
    }

    /**
     *containsWhitespace():判断是否包含空格，包含返回true
     */
    public static void isContainsWhitespace(){
        String str1 = null;
        String str2 = "";
        String str3 = " ";
        String str4 = "hello";
        String str5 = " hello ";
        Assert.assertEquals(StringUtils.containsWhitespace(str1),false);
        Assert.assertEquals(StringUtils.containsWhitespace(str2),false);
        Assert.assertEquals(StringUtils.containsWhitespace(str3),true);
        Assert.assertEquals(StringUtils.containsWhitespace(str4),false);
        Assert.assertEquals(StringUtils.containsWhitespace(str5),true);
    }

    /**
     * trimWhitespace():去除字符串首尾空格
     */
    public static void trimWhitespaceTest(){
        String before = " hello ";
        String after = StringUtils.trimWhitespace(before);
        Assert.assertNotSame(before,after);
    }

    /**
     * trimAllWhitespace():去除字符串全部空格
     */
    public static void trimAllWhitespaceTest(){
        String before = " hello world ";
        String after = StringUtils.trimAllWhitespace(before);
        Assert.assertNotSame(before,after);
        if(after.equals("helloworld")){
            System.out.println("ok");
        }
    }

    /**
     * trimLeadingWhitespace():去除字符串首部空格
     */
    public static void trimLeadingWhitespaceTest(){
        String before = " hello world ";
        String after = StringUtils.trimLeadingWhitespace(before);
        Assert.assertNotSame(before,after);
        if(after.equals("hello world ")){
            System.out.println("ok");
        }
    }

    /**
     * trimTrailingWhitespace():去除字符串尾部空格
     */
    public static void trimTrailingWhitespaceTest(){
        String before = " hello world ";
        String after = StringUtils.trimTrailingWhitespace(before);
        Assert.assertNotSame(before,after);
        if(after.equals(" hello world")){
            System.out.println("ok");
        }
    }

    /**
     * trimLeadingCharacter():去除符合条件的首部字符
     */
    public static void trimLeadingCharacterTest(){
        String result = StringUtils.trimLeadingCharacter("hello",'h');
        if(result.equals("ello")){
            System.out.println("ok");
        }
    }

    /**
     * startsWithIgnoreCase():判断前缀是否匹配，忽略大小写
     */
    public static void startsWithIgnoreCaseTest(){
        Assert.assertEquals(StringUtils.startsWithIgnoreCase("hello","hel"),true);
    }

    /**
     * substringMatch():判断指定index开始的string与substring是否匹配
     */
    public static void substringMatchTest(){
        Assert.assertEquals(StringUtils.substringMatch("hello",2,"ll"),true);
    }

    /**
     * countOccurrencesOf():计算子串sub在主串str中出现的次数
     */
    public static void tescountOccurrencesOfTest(){
        String str = "hello ello";
        String sub = "ell";
        Assert.assertEquals(StringUtils.countOccurrencesOf(str, sub),2);
    }

    /**
     * delete():删除所有主串中substr的内容
     */
    public static void deleteTest(){
        String str = "hello ello";
        String substr = "ell";
        String result = StringUtils.delete(str,substr);
        if(result.equals("ho o")){
            System.out.println("ok");
        }
    }

    /**
     * quote():返回单引号字符串结果
     */
    public static void quoteTest(){
        String result = StringUtils.quote("hello");
        if(result.equals("'hello'")){
            System.out.println("ok");
        }
    }

    /**
     * unqualify():返回字符串指定分隔符的最后子串
     */
    public static void unqualifyTest(){
        String result = StringUtils.unqualify("this:name:is:qualified",':');
        if(result.equals("qualified")){
            System.out.println("ok");
        }
    }

    /**
     * capitalize():字符串首字符大写
     */
    public static void capitalizeTest(){
        String result = StringUtils.capitalize("hello world");
        if(result.equals("Hello world")){
            System.out.println("ok");
        }
    }

    /**
     * getFilename():获取指定路径的文件名
     */
    public static void getFilenameTest(){
        String path = "/mypath/myfile.txt";
        String result = StringUtils.getFilename(path);
        if(result.equals("myfile.txt")){
            System.out.println("ok");
        }
    }

    /**
     * getFilenameExtension():获取文件扩展名
     */
    public static void getFilenameExtensionTest(){
        String path = "/mypath/myfile.txt";
        String result = StringUtils.getFilenameExtension(path);
        if(result.equals("txt")){
            System.out.println("ok");
        }
    }

    /**
     * applyRelativePath():使用相对路径
     */
    public static void applyRelativePathTest(){
        String path = "/mypath/myfile.txt";
        String relativePath = "/a/b.txt";
        String result = StringUtils.applyRelativePath(path, relativePath);
        if(result.equals("/mypath/a/b.txt")){
            System.out.println("ok");
        }
    }

    /**
     *cleanPath():清理路径中的../规则
     */
    public static void cleanPathTest(){
        String path = "/mypath/a/myfile.txt.";
        String relativePath = "../b/newfile.txt";
        String result = StringUtils.cleanPath(StringUtils.applyRelativePath(path, relativePath));
        if("/mypath/b/newfile.txt".equals(result)){
            System.out.println("ok");
        }
    }

    /**
     * pathEquals():判断源路径与目的路径是否相同
     */
    public static void pathEqualsTest(){
        String sourcePath = "/mypath/myfile.txt";
        String  targetPath = "/mypath/myfile.txt";
        Assert.assertEquals(StringUtils.pathEquals(sourcePath,targetPath),true);
    }

    /**
     * toStringArray():集合转数组,仅支持集合元素为string
     */
    public static void toStringArrayTest(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
       String[] results = StringUtils.toStringArray(list);
        for (String result : results) {
            System.out.println(result);
        }
    }

    /**
     * addStringToArray():添加string元素到数组
     */
    public static void addStringToArrayTest(){
        String[] array = new String[]{"a","b"};
        String[] results = StringUtils.addStringToArray(array, "c");
        String[] expecteds = {"a","b","c"};
        Assert.assertArrayEquals(expecteds,results);
    }

    /**
     * concatenateStringArrays():拼接两个数组，不去重
     */
    public static void concatenateStringArraysTest(){
        String[] str1 = {"a", "b", "c"};
        String[] str2 = {"c", "d", "e"};
        String[] results = StringUtils.concatenateStringArrays(str1, str2);
        String[] expecteds = {"a", "b", "c", "c", "d", "e"};
        Assert.assertArrayEquals(expecteds,results);
    }

    /**
     * sortStringArray():数组元素排序
     */
    public static void sortStringArrayTest(){
        String[] str1 = {"b", "a", "c"};
        String[] results = StringUtils.sortStringArray(str1);
        String[] expecteds = {"a", "b", "c"};
        Assert.assertArrayEquals(expecteds,results);
    }

    /**
     * trimArrayElements():去除数组中元素的首尾空格
     */
    public static void trimArrayElementsTest(){
        String[] str1 = {"a ", "b   ", "c"};
        String[] results = StringUtils.trimArrayElements(str1);
        String[] expecteds = {"a", "b", "c"};
        Assert.assertArrayEquals(expecteds,results);
    }

    /**
     * removeDuplicateStrings():去除数组中重复的元素
     */
    public static void removeDuplicateStrings(){
        String[] str1 = {"a", "b", "a", "c"};
        String[] results = StringUtils.removeDuplicateStrings(str1);
        String[] expecteds = {"a", "b", "c"};
        Assert.assertArrayEquals(expecteds,results);
    }

    /**
     * split():字符串分割，仅匹配第一个分隔符
     */
    public static void splitTest(){
        String str = "this:name:is:qualified";
//        String[] str1 = str.split(":");
//        for (String s : str1) {
//            System.out.println(s);
//        }
        String[] results = StringUtils.split(str,":");
        String[] expecteds = {"this", "name:is:qualified"};
        Assert.assertArrayEquals(expecteds,results);
    }

    /**
     * splitArrayElementsIntoProperties():分割数组元素为map结构
     */
    public static void splitArrayElementsIntoPropertiesTest(){
        String[] str1 = {"key1:value1", "key2:value2"};
        Hashtable<Object,Object> maps = StringUtils.splitArrayElementsIntoProperties(str1,":");
        for (Map.Entry<Object, Object> objectEntry : maps.entrySet()) {
            System.out.println(objectEntry.getKey() +" -"+ objectEntry.getValue());
        }
    }

    /**
     * tokenizeToStringArray():指定多分隔符，每个元素代表一个分隔符
     * trimTokens:是否去空格
     * ignoreEmptyTokens:是否忽略空内容
     */
    public static void tokenizeToStringArrayTest(){
        String str = "this: name is: :qualified/key1:value1";
//        String[] results = str.split(":|/");
//        for (String result : results) {
//            System.out.println(result);
//        }
        String[] results = StringUtils.tokenizeToStringArray(str,":/",true, true);
        for (String result : results) {
            System.out.println(result);
        }
    }

    /**
     * delimitedListToStringArray():指定分隔符，针对复杂分隔符情况
     * 输出：
     * this
     * name is
     * qualified/key1:value1
     */
    public static void delimitedListToStringArrayTest(){
        String str = "this::name is::qualified:key1:value1";
        String[] results = StringUtils.delimitedListToStringArray(str,"::");
        for (String result : results) {
            System.out.println(result);
        }
    }

    /**
     * commaDelimitedListToSet():转化以逗号为分隔符的元素到Set集合
     */
    public static void commaDelimitedListToSetTest(){
        String str = "a,b,c,d,b,e,f";
        Set<String> results = StringUtils.commaDelimitedListToSet(str);
        for (String result : results) {
            System.out.println(result);
        }
    }

    /**
     * collectionToDelimitedString(): 将集合转化为指定分隔符的字符串
     */
    public static void collectionToDelimitedStringTest(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String result = StringUtils.collectionToDelimitedString(list,":");
        Assert.assertEquals("a:b:c",result);
    }

    /**
     * arrayToDelimitedString():将数组转化为指定分隔符的字符串
     */
    public static void arrayToDelimitedStringTest(){
        Integer[] array = {1,2,3,4};
        String result = StringUtils.arrayToDelimitedString(array,":");
       Assert.assertEquals("1:2:3:4",result);
    }

    public static void main(String[] args) {
        
    }
}
