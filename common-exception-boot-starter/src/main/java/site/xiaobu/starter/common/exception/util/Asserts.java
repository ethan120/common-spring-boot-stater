package site.xiaobu.starter.common.exception.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import site.xiaobu.starter.common.base.IResponse;
import site.xiaobu.starter.common.exception.exception.AssertException;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * 断言工具类
 */
public final class Asserts {
    /**
     * 创建一个断言对象
     */
    public static InternalAssert asserts() {
        return new InternalAssert();
    }


    /**
     * 内部断言类
     */
    public static class InternalAssert {
        /**
         * 当前断言情况
         */
        private boolean status = true;

        /**
         * 如果不满足断言条件,抛出断言异常
         *
         * @param res 响应对象
         */
        public void ifNot(IResponse res) {
            if (!this.status) {
                throw new AssertException(res);
            }
        }

        /**
         * 如果不满足断言条件,执行自定义逻辑
         *
         * @param function 自定义逻辑对象
         */
        public Object ifNot(IfNotFunction function) {
            if (!this.status) {
                return function.exec();
            }
            return this;
        }

        /**
         * 断言一个对象不是 null
         */
        public InternalAssert notNull(Object obj) {
            if (!this.status) return this;
            if (obj == null) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言一个对象为 null
         */
        public InternalAssert isNull(Object obj) {
            if (!this.status) return this;
            if (obj != null) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言一个对象非空
         * 可以断言的类型有：
         * Collection
         * Iterable
         * Iterator
         * Map
         * Enumeration
         * CharSequence
         */
        public InternalAssert notEmpty(Object obj) {
            if (!this.status) return this;
            if (obj instanceof Collection) {
                if (CollUtil.isEmpty((Collection<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Iterable) {
                if (CollUtil.isEmpty((Iterable<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Iterator) {
                if (CollUtil.isEmpty((Iterator<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Map) {
                if (CollUtil.isEmpty((Map<?, ?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Enumeration) {
                if (CollUtil.isEmpty((Enumeration<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof CharSequence) {
                if (StrUtil.isEmpty((CharSequence) obj)) {
                    this.status = false;
                    return this;
                }
            }
            return this;
        }

        /**
         * 断言一个对象为空
         * 可以断言的类型有：
         * Collection
         * Iterable
         * Iterator
         * Map
         * Enumeration
         * CharSequence
         */
        public InternalAssert isEmpty(Object obj) {
            if (!this.status) return this;
            if (obj instanceof Collection) {
                if (CollUtil.isNotEmpty((Collection<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Iterable) {
                if (CollUtil.isNotEmpty((Iterable<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Iterator) {
                if (CollUtil.isNotEmpty((Iterator<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Map) {
                if (CollUtil.isNotEmpty((Map<?, ?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof Enumeration) {
                if (CollUtil.isNotEmpty((Enumeration<?>) obj)) {
                    this.status = false;
                    return this;
                }
            }
            if (obj instanceof CharSequence) {
                if (StrUtil.isNotEmpty((CharSequence) obj)) {
                    this.status = false;
                    return this;
                }
            }
            return this;
        }


        /**
         * 断言一个表达式为假
         */
        public InternalAssert isFalse(Boolean expression) {
            if (!this.status) return this;
            if (BooleanUtil.isTrue(expression)) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言一个表达式为真
         */
        public InternalAssert isTrue(Boolean expression) {
            if (!this.status) return this;
            if (BooleanUtil.isFalse(expression)) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言字符串包含至少一个字串
         */
        public InternalAssert contains(CharSequence sourceStr, CharSequence subStr) {
            if (!this.status) return this;
            if (!StrUtil.contains(sourceStr, subStr)) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言字符串不包含一个字串
         */
        public InternalAssert notContains(CharSequence sourceStr, CharSequence subStr) {
            if (!this.status) return this;
            if (StrUtil.contains(sourceStr, subStr)) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言一个集合包含一个元素
         */
        public InternalAssert contains(Collection<?> source, Object target) {
            if (!this.status) return this;
            if (!CollUtil.contains(source, target)) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言一个集合不包含一个元素
         */
        public InternalAssert notContains(Collection<?> source, Object target) {
            if (!this.status) return this;
            if (CollUtil.contains(source, target)) {
                this.status = false;
            }
            return this;
        }

        /**
         * 断言一个自定义内容
         */
        public InternalAssert state(Supplier supplier) {
            if (!this.status) return this;
            if (!supplier.supply()) {
                this.status = false;
            }
            return this;
        }
    }
}
