### java范型
https://www.oracle.com/technetwork/cn/articles/java/juneau-generics-2255374-zhs.html

范型：参数化类型，使用广泛的类型

作用：
- 安全：在编译时检查类型安全
- 省心：所有的强制转换都是自动和隐式的，提高代码的重用率

实例：您希望开发一个用于在应用中传递对象的容器。但对象类型并不总是相同。因此，需要开发一个能够存储各种类型对象的容器。

```
列出每个用例的标准类型参数：

E：元素
K：键
N：数字
T：类型
V：值
S、U、V 等：多参数情况中的第 2、3、4 个类型

```

```
当我们需要传入的参数类型不能确定时，可使用范型
extend number限定类型必须是数值型

public static <N extends Number> double add(N a, N b){
    double sum = 0;
    sum = a.doubleValue() + b.doubleValue();
    return sum;
}   
```
