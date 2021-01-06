package site.xiaobu.starter.common.exception;

import org.springframework.util.StringUtils;
import site.xiaobu.starter.common.common.IResponse;

import java.util.Collection;
import java.util.Map;

/**
 * @Description: 断言
 * @Author: zhanghuan
 * @Date: 2021-01-06 17:47
 * @Version: V1.0
 */
public class Asserts {
    public static void notNull(Object obj, IResponse response) {
        if (obj == null) {
            throw new BusinessException(response);
        }
    }

    public static void isNull(Object obj, IResponse response) {
        if (obj != null) {
            throw new BusinessException(response);
        }
    }

    public static void notEmpty(String str, IResponse response) {
        if (StringUtils.isEmpty(str)) {
            throw new BusinessException(response);
        }
    }

    public static void isEmpty(String str, IResponse response) {
        if (!StringUtils.isEmpty(str)) {
            throw new BusinessException(response);
        }
    }

    public static void notEmpty(Collection<?> collection, IResponse response) {
        if (collection == null || collection.size() == 0) {
            throw new BusinessException(response);
        }
    }

    public static void isEmpty(Collection<?> collection, IResponse response) {
        if (collection != null && collection.size() > 0) {
            throw new BusinessException(response);
        }
    }

    public static void notEmpty(Map<?, ?> map, IResponse response) {
        if (map == null || map.size() == 0) {
            throw new BusinessException(response);
        }
    }

    public static void isEmpty(Map<?, ?> map, IResponse response) {
        if (map != null && map.size() > 0) {
            throw new BusinessException(response);
        }
    }

    public static void notEmpty(Object[] array, IResponse response) {
        if (array == null || array.length == 0) {
            throw new BusinessException(response);
        }
    }

    public static void isEmpty(Object[] array, IResponse response) {
        if (array != null && array.length > 0) {
            throw new BusinessException(response);
        }
    }

    public static void isTrue(boolean expression, IResponse response) {
        if (!expression) {
            throw new BusinessException(response);
        }
    }

    public static void isFalse(boolean expression, IResponse response) {
        if (expression) {
            throw new BusinessException(response);
        }
    }

    public static void contains(String sourceStr, CharSequence subStr, IResponse response) {
        if (!StringUtils.isEmpty(sourceStr) && !StringUtils.isEmpty(sourceStr) && subStr.length() < sourceStr.length()) {
            if (!sourceStr.contains(subStr)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void contains(Collection<?> source, Object target, IResponse response) {
        if (source != null && source.size() > 0 && target != null) {
            if (!source.contains(target)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void contains(Object[] source, Object target, IResponse response) {
        if (source != null && source.length > 0 && target != null) {
            boolean contains = false;
            for (Object o : source) {
                if (o.equals(target)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                throw new BusinessException(response);
            }
        }
    }

    public static void containsKey(Map<?, ?> map, Object key, IResponse response) {
        if (map != null && map.size() > 0) {
            if (!map.containsKey(key)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void containsValue(Map<?, ?> map, Object value, IResponse response) {
        if (map != null && map.size() > 0) {
            if (!map.containsValue(value)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void notContains(String sourceStr, CharSequence subStr, IResponse response) {
        if (!StringUtils.isEmpty(sourceStr) && !StringUtils.isEmpty(sourceStr) && subStr.length() < sourceStr.length()) {
            if (sourceStr.contains(subStr)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void notContains(Collection<?> source, Object target, IResponse response) {
        if (source != null && source.size() > 0 && target != null) {
            if (source.contains(target)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void notContains(Object[] source, Object target, IResponse response) {
        if (source != null && source.length > 0 && target != null) {
            for (Object o : source) {
                if (o.equals(target)) {
                    throw new BusinessException(response);
                }
            }
        }
    }

    public static void notContainsKey(Map<?, ?> map, Object key, IResponse response) {
        if (map != null && map.size() > 0) {
            if (map.containsKey(key)) {
                throw new BusinessException(response);
            }
        }
    }

    public static void notContainsValue(Map<?, ?> map, Object value, IResponse response) {
        if (map != null && map.size() > 0) {
            if (map.containsValue(value)) {
                throw new BusinessException(response);
            }
        }
    }
}
