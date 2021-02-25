package com.java.learn.generic.demo;

/**
 * 一般来说，你并不想要编写多个分别处理不同数据类型，但内在逻辑代码却完全一样的类。
 * 因为这些处理类可能除了数据类型变换了一下外，所有代码都完全一致。
 * <p>
 * 使用T而不使用object的优点：
 * 1. 规范、简化了编码: 我们不用在每次get操作时候都要做强制类型转换了
 * 2. 良好的可读性：GenericArray<String> arr这一声明能清晰地看出GenericArray中存储的数据类型
 * 3. 安全性：使用了泛型机制后，编译器能在set操作中检测传入的参数是否为T类型， 同时检测get操作中返回值是否为T类型，如果不通过则编译报错
 * <p>
 * 在定义泛型类时不能做的事：
 * 1. 不能实例化类型变量，如果实在要创建一个泛型对象的话，可以使用反射，参见{@link GenericObj}
 * 2. 不能实例化泛型数组，如T [] arr = new T[3];
 * 3. 不能使用基本类型的值作为类型变量的值，e.g：Foo<int> node = new Foo<int> (); // 非法
 * 4. 不能创建泛型类的数组，e.g：Foo<Node> [] f =new Foo<Node> [6]; // 报错
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/25 11:11
 */
public class Generic<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public T getRes(T data) {
        return (T) data.toString().toLowerCase();
    }

}
