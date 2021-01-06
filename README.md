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

#### 1.2 断言的使用

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

在业务中使用断言:

```
public CommonResponse<?> business(String name) {
    // 根据 name 查询用户伪代码
    User user = userDao.selectUserByName(name);
    
    // 用户不能为空,为空的话业务不成立
    // 这里会判断用户是否为空,如果为空会抛出 BuinessException,该异常会被基础异常处理器处理,并根据枚举类的 code,message 值响应结果
    Asserts.notNull(user, BusinessEnum.BAD);

    // 将用户设为管理员伪代码
    userService.serAdmin(user);
    return Resp.new200("设置成功");
}
```
