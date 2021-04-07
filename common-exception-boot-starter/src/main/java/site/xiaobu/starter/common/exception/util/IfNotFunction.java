package site.xiaobu.starter.common.exception.util;


/**
 * 可以实现该接口做断言失败的处理
 * 配合 Asserts 类使用
 */
@FunctionalInterface
public interface IfNotFunction {
    Object exec();
}
