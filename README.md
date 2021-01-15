# 基于SpringBoot的Web开发公共服务

## 一、统一异常处理

### 1.1 异常处理器

**1.1.1 基础异常处理器**

基础异常处理器,负责处理一些基础的异常:

| 异常类型 | 响应码 | 响应文本 |
| ---- | ---- | ---- |
| BusinessException | 可自定义 | 可自定义 |
| NullPointerException | 500 | 空指针异常 |
| Exception | 500 | 未知异常 |

**1.1.2 数据访问异常处理器**

负责处理数据库访问产生的异常:

| 异常类型 | 响应码 | 响应文本 |
| ---- | ---- | ---- |
| DataAccessException | 500 | 数据访问错误 |

**1.1.3 Servlet异常处理器**

负责处理 Servlet 产生的异常:

| 异常类型 | 响应码 | 响应文本 |
| ---- | ---- | ---- |
| DataAccessException | 500 | 数据访问错误 |
| NoHandlerFoundException | 404 | 没有对应的处理器 |
| HttpRequestMethodNotSupportedException | 405 | 不支持的请求方式 |
| HttpMediaTypeNotSupportedException | 415 | 不支持的Content-Type |
| MissingPathVariableException | 400 | 缺少路径参数 |
| MissingServletRequestParameterException | 400 | 缺少请求参数 |
| TypeMismatchException | 400 | 参数类型不匹配 |
| HttpMessageNotReadableException | 400 | 前端不支持的Content-Type |
| HttpMessageNotWritableException | 400 | 请求缺失了一部分 |
| HttpMediaTypeNotAcceptableException | 400 | 异步请求超时 |
| ServletRequestBindingException | 400 | 序列化请求值失败 |
| ConversionNotSupportedException | 400 | 序列化响应值失败 |
| MissingServletRequestPartException | 400 | 参数绑定失败 |
| AsyncRequestTimeoutException | 400 | 类型转换失败 |

**1.1.4 参数校验异常处理器**

负责处理参数校验产生的异常:

| 异常类型 | 响应码 | 响应文本 |
| ---- | ---- | ---- |
| ConstraintViolationException | 400 | 参数校验发生异常 |
| BindException | 400 | 参数校验发生异常 |
| MethodArgumentNotValidException | 400 | 参数校验发生异常 |

此异常处理器会将校验失败失败的详细信息返回!

### 1.2 断言的使用

包含了工具类 Asserts,可以使用此工具类优化 if else 等代码的编写,使用示例:

定义自己的业务异常枚举类并实现 IResponse 接口:
```
public enum BusinessEnum implements IResponse {

    BAD(500, "业务异常");

    private int code;

    private String message;

    BusinessEnum(int i, String ddd) {
        this.code = i;
        this.message = ddd;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
```

在程序中使用断言:

```
public CommonResponse<?> business(String name) {
    // 根据 name 查询用户伪代码
    User user = userDao.selectUserByName(name);
    
    // 用户不能为空,为空的话业务不成立,程序不能继续执行
    // 这里会判断用户是否为空,如果为空会抛出 ApplicationException,该异常会被基础异常处理器处理,并根据枚举类的 code,message 值响应结果
    Asserts.notNull(user, BusinessEnum.BAD);

    // 将用户设为管理员伪代码
    userService.serAdmin(user);
    return Resp.new200("设置成功");
}
```

自定义断言逻辑:
可以使用 Asserts.state() 方法自定义断言逻辑,下面模拟一个扣减库存的场景:

```
public synchronized void reduceStocks(String name,int count) {
    // 根据材料名获取当前库存
    final int currentStocks = getOriginStocks(name);

    // 如果扣减库存要变为负数了就不能扣,并抛出异常
    Asserts.state(() -> currentStocks - count >= 0, BusinessEnum.BAD);
    
    // 真正扣减库存
    repository.reduceStocks(name,count);
}
```

### 1.3 异常的设计

在 Java 异常体系中,Throwable 是所有异常的超类,然后和向下分出了 Error 和 Exception.

Error是程序无法处理的错误，比如OutOfMemoryError、ThreadDeath、NoClassDefFoundError等。这些异常发生时，Java虚拟机（JVM）一般会选择线程终止。
Exception是程序本身可以处理的异常，这种异常分两大类运行时异常和非运行时异常。程序中应当尽可能去处理这些异常，使程序继续正常运行。

Exception 又可分为两类:

- 运行时异常
运行时异常都是RuntimeException类及其子类异常,如NullPointerException、IndexOutOfBoundsException等，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。
这些异常一般是由程序逻辑错误引起，程序应从逻辑角度尽可能避免这类异常的发生，一旦发生程序一般没有按照错误逻辑运行下去的必要。

- 非运行时异常
非运行时异常是RuntimeException以外的异常，类型上都属于Exception类及其子类。从程序语法角度讲是必须进行处理的异常，如果不处理，程序就不能编译通过。如IOException、SQLException等以及用户自定义的Exception异常，一般情况下不自定义检查异常。
受检异常一般是与程序与外界交互失败才会抛出，希望可以处理使程序正常运行。

我们使用 Java 开发一个应用程序,就代表我们接受了 Java 的异常体系,基于这样的异常体系下,设计了 ApplicationException 继承于 RuntimeException 作为这个应用程序所有具体异常的基类.
该异常基类需要聚合一个 IResponse 对象,可以基于此对象来判断异常的原因与状态码.
断言类抛出的异常也是 ApplicationException 类.