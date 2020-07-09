## Java反射

反射链接：[反射学习网址](https://www.sczyh30.com/posts/Java/java-reflection-1/#一、回顾：什么是反射？) 

### 1. 什么是反射

反射：将类中的各个组成部分封装为其他对象，这就是反射机制。

反射 (Reflection) 是 Java 的特征之一，它允许运行中的 Java 程序获取自身的信息，并且可以操作类或对象的内部属性。

 

在java.lang.reflect包中有三个类：Field类、Method类和Constructor类分别描述了一个类的域、方法、构造函数。Field类有一个getType方法，该方法返回一个Class类型的对象，描述域的类型信息。

 ![image-20200704173323439](https://raw.githubusercontent.com/kender1314/NotePicture/master/20200704184824.png)

**反射主要提供的功能：**

-   在运行时判断任意一个对象所属的类；


- 在运行时构造任意一个类的对象；

- 在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用private方法）；

- 在运行时调用任意一个对象的方法


重点：**是运行时而不是编译时**

### 2. 反射主要用途

**反射最重要的用途就是开发各种通用框架。**很多框架（比如 Spring）都是配置化的（比如通过 XML 文件配置 Bean），为了保证框架的通用性，它们可能需要根据配置文件加载不同的对象或类，调用不同的方法，这个时候就必须用到反射，运行时动态加载需要加载的对象。



### 3. 反射结构图

![image-20200706233838603](https://raw.githubusercontent.com/kender1314/NotePicture/master/20200706233838.png)



### 4. 反射的好处

1. 可以在程序运行过程中，操作这些对象。

   在Idea运行过程中，就可以使用代码自动补全工具，比如输入string.之后，会提示你想要输入的方法（本例中使用了length()方法）：

   ```
   String string = "";
   System.out.println(string.length());
   ```

   为什么我能调用string的length()方法呢，这就是通过反射原理。

2. 可以解耦，提高程序的可扩展性。



### 5. 获取类对象的方式

总共分为三种方式，分别对应Java代码在计算机中的三个方向：

1. Class.forName("全类名")：将字节码文件 加载进内存，返回Class对象。（全类名：包路径+类名）。（源代码阶段（Source））

   *多用于配置文件

2. 类名.class：通过类名的属性class获取。（类对象阶段阶段（Class））

   *多用于参数传递

3. 实例对象.getClass()：getClass()方法在Object中定义的。（运行时阶段（Runtime））

   *多用于对象的获取字节码的方式

结论：在一次程序运行过程中，同一个字节码文件，只会被加载一次，不管你用什么方式将该类加载进入内存，获取到的Class对象，都是同一个。

### 6. Class对象功能

#### 获取功能

1. 获取成员变量数组

   ```
   Field[] getFields()
   Field getField(String name)
   
   Field[] getDeclaredFields()
   Field getDeclaredField(String name)
   ```

   

1. 获取构造方法数组

   ```
   Constructor<?>[] getDeclaredConstructors() 
   Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 
   
   Constructor<T> getConstructor(Class<?>... parameterTypes) 
   Constructor<?>[] getConstructors() 
   ```

   

2. 获取成员方法数组

   ```
   Method getDeclaredMethod(String name, Class<?>... parameterTypes) 
   Method[] getDeclaredMethods() 
   
   Method getMethod(String name, Class<?>... parameterTypes) 
   Method[] getMethods() 
   ```

   

3. 获取类名

   ```
   String getName()
   ```

   









