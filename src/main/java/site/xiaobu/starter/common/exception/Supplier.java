package site.xiaobu.starter.common.exception;

/**
 * @Description: 可以实现该接口做自定义逻辑处理
 * 配合 Asserts 类使用
 * @Author: zhanghuan
 * @Date: 2021-01-15 10:40
 * @Version: V1.0
 */
@FunctionalInterface
public interface Supplier {
    boolean supply();
}
