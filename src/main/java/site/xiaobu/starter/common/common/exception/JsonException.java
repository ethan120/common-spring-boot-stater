package site.xiaobu.starter.common.common.exception;

/**
 * @Description: Json处理异常
 * @Author: zhanghuan
 * @Date: 2020-12-28 12:41
 * @Version: V1.0
 */
public class JsonException extends RuntimeException {
    private String json;
    private Object obj;
    private Class<?> clazz;

    public JsonException(String message) {
        super(message);
    }

    public JsonException() {
        super();
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
