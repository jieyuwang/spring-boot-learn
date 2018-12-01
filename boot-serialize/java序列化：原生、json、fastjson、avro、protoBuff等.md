对比的文章：

[Protobuf有没有比JSON快5倍？用代码来击破pb性能神话 ](http://www.sohu.com/a/136487507_505779   )

[jvm-serializes](https://github.com/eishay/jvm-serializers/wiki)
[中文版本的jvm-serializes](https://blog.csdn.net/smallnest/article/details/38847653)

[[java]序列化框架性能对比（kryo、hessian、java、protostuff)](https://www.cnblogs.com/lonelywolfmoutain/p/5563985.html)

[【转】几种Java序列化方式的实现](https://www.cnblogs.com/didiaoxiong/p/9067781.html)

#### 原生

缺点：
    
    1.序列化后很大，比较繁重，原因是：serialize的类型比较多
    2.serialize的速度在大数据量的情况下比json差了快一个数量级。

优点：
    1.适用范围广，什么对象都可以序列化
    

#### AVRO


存储结构：
![imag](https://img-blog.csdn.net/20180124142332767?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHVkYWNoZW5fZw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
首先，开头4个字符为Obj加上一个long类型的版本号的byte[]数据，MetaData区域存储为一个long类型的map start标记。然后是map，这个map里面存储的key为avro.schema，value为schema转化成的byte[]。sync为16字节同步标记，可以自己设定，或者通过计算获得。Data Block区域存储第一个是Object Num对象数量，Block Size 为块大小，即后面Datas的长度。Datas存储为数据序列化后的数据。最后又是sync 16字节同步标记。

应用

    Hadoop RPC （http://hadoop.apache.org/#What+Is+Apache+Hadoop%3F）
    
优点

    二进制消息，性能好/效率高
    使用JSON描述模式
    模式和数据统一存储，消息自描述，不需要生成stub代码（支持生成IDL）
    RPC调用在握手阶段交换模式定义
    包含完整的客户端/服务端堆栈，可快速实现RPC
    支持同步和异步通信
    支持动态消息
    模式定义允许定义数据的排序（序列化时会遵循这个顺序）
    提供了基于Jetty内核的服务基于Netty的服务
    1 丰富的数据结构类型 
    2 快速可压缩的二进制数据形式 
    3 存储持久数据的文件容器 
    4 远程过程调用RPC 
    5 简单的动态语言结合功能，Avro和动态语言结合后，读写数据文件和使用RPC协议都不需要生成代码，而代码生成作为一种可选的优化只值得在静态类型语言中实现。

缺点

    只支持Avro自己的序列化格式
    语言绑定不如Thrift丰富
参考文档：

[大数据笔记13：Java原生序列化、Avro、RPC与Log4j](https://blog.csdn.net/howard2005/article/details/79424029)

[avro的javaapi](http://avro.apache.org/docs/1.7.7/api/java/index.html)

[官网](http://avro.apache.org/docs/1.7.7/gettingstartedjava.html)

[Arvo的Scheme规范](https://blog.csdn.net/eieiei438/article/details/81635115)

#### protoBuff 

　protobuf是谷歌推出的与语言无关、平台无关的通信协议，一个对象经过protobuf序列化后将变成==二进制==格式的数据，所以他可读性差，但换来的是==占用空间小，速度快==。使用protobuf要先使用特定的语法编写一个.proto文件，该文件与语言无关，然后使用特殊的编译器对该文件进行编译，生成与语言相关的文件，如java，那么将生成java的类，该类不仅有我们自己定义的属性，还提供了序列化，反序列化等其他方法。直接把该类copy到项目中，就可以使用了。不过缺点是，假如我们是数据的发送方，那么接受方也要有一个通过相同的.proto编译出来的“类”（假设对方使用java语言），才可以顺利地进行反编译。这样一来，假如我们对proto 2.6版本的编辑器对.proto文件进行编译，而对方使用的是2.3版本的编译器进行编译，那么编译出来的类是不一样的，==且两个版本互不兼容==。所以两方的版本要保持一致。这么一来，假如一方升级，但没及时通知另一方，那么可能导致对方无法反序列化！这个缺点也是不小的。
　
>快的理由：利用算法生成二进制流，序列化与反序列化不需要解析相应的节点属性和多余的描述信息，所以序列化和反序列化时间效率较高。

优点:

    1：序列化后体积相比Json和XML很小，适合网络传输，空间效率是JSON的2-5倍，时间效率要高
    2：支持跨平台多语言
    3：消息格式升级和兼容性还不错
    4：序列化反序列化速度很快，快于Json的处理速度
缺点：

    1：消息结构可读性不高，序列化后的字节序列为二进制序列不能简单的分析有效性；
    2：目前使用不广泛，只支持java,C++和Python；

参考：

[官网](https://code.google.com/p/protostuff/)

[Google protobuf序列化以及反序列化](https://www.cnblogs.com/gdpuzxs/p/7081145.html)

[通讯协议序列化解读（一） Protobuf详解教程](https://www.cnblogs.com/tohxyblog/p/8974641.html)

#### json

json一共有三个，jackson、fastjson、gson等 其中jackson最高效。FastJSON和GsonJSON序列化的速度差不多，Jackson是最快的

>ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。 ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。

优点：
    
    1.JSON格式与语言无关，扩展性强，速度也应该不慢。
    2.json和xml自带很多描述结构的语言，简洁易懂
    
缺点：

    1.json无法处理对象方法等数据。
    
[FastJSON、Gson和Jackson性能对比和共同缺点,注意事项](https://blog.csdn.net/qq_28572235/article/details/78604846)
    
##### fackson

JackSon提供了三种JSON的处理方式。分别是数据绑定，树模型，流式API。下面会分别介绍这三种方式。

数据绑定：

将json字符串映射为对象，或者是将对象转化为json字符串。这是完整数据绑定。 缺点:这种方法十分方便，但是扩展性不强，增加一个字段便要修改POJO对象，这个操作有一定风险性。并且解析的时候，如果json缺少POJO中的某字段，映射出的对象对应值默认为null，直接使用有一定风险。如果json对象多了某一字段，解析过程中会抛出UnrecognizedPropertyException异常。并且如果json较为复杂的话，POJO对象会显得特别臃肿。 

树模型:

JackSon树模型结构，可以通过get，JsonPointer等进行操作，适合用来获取大Json中的字段，比较灵活。缺点是如果需要获取的内容较多，
会显得比较繁琐。

流式api：

流式API是一套比较底层的API，速度快，但是使用起来特别麻烦。它主要是有两个核心类，一个是JsonGenerator，用来生成json，另一个是JsonParser，用来读取json内容。

参考：

[JackSon的几种用法](https://blog.csdn.net/m0_37076574/article/details/81317403)
[Jackson教程](https://www.yiibai.com/jackson/)


#### FST (fast-serialization)

优点：

    fst是完全兼容JDK序列化协议的系列化框架，序列化速度大概是JDK的4-10倍，大小是JDK大小的1/3左右。而且兼容 JDK 原生的序列化。要求 JDK 1.7 支持。
    序列化速度更快，对象变得更小。
    简易替代者。类序列化时不需要getters、setters、Constructors和Interfaces；扩展了Outputstream，实现了ObjectInput/ObjectOutput接口。 使用时对原来的代码改动很小。
    完全支持JDK序列化的主要功能，例如Externalizable中的writeObject、readObject、readReplace、validation、putField、getField方法，可自定义钩子等等。JDK序列化的对象可以直接用FST处理。
    序列化的对象中保留的连接关系图与JDK默认序列化结果保持一致。
    通过注解、自定义serializer支持自定义优化。
    支持序列化版本（仅2.x支持）
    JSON序列化/反序列化支持（可选）
    条件解码（可根据要求跳过对象/流中部分内容的解码）

参考：

[官网](https://ruedigermoeller.github.io/fast-serialization/)

[开源地址](https://github.com/RuedigerMoeller/fast-serialization)

####    protostuff
Protocol Buffer是谷歌出品的一种数据交换格式，独立于语言和平台，类似于json。Google提供了多种语言的实现：java、c++、go和python。对象序列化城Protocol Buffer之后可读性差，但是相比xml，json，它占用小，速度快。适合做数据存储或 RPC 数据交换格式。

相对我们常用的json来说，Protocol Buffer门槛更高，因为需要编写.proto文件，再把它编译成目标语言，这样使用起来就很麻烦。但是现在有了protostuff之后，就不需要依赖.proto文件了，他可以直接对POJO进行序列化和反序列化，使用起来非常简单


#### kryo

Kryo是一个快速高效的Java序列化框架，旨在提供快速、高效和易用的API。无论文件、数据库或网络数据Kryo都可以随时完成序列化。Kryo还可以执行自动深拷贝（克隆）、浅拷贝（克隆）。这是对象到对象的直接拷贝，非对象->字节->对象的拷贝。

优点：

    速度快，序列化后体积小
    
缺点：
    
    跨语言支持较复杂
[教程](http://hao.jobbole.com/kryo/)
[开源地址](https://github.com/EsotericSoftware/kryo)

    
