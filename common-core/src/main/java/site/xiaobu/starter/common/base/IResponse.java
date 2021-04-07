package site.xiaobu.starter.common.base;

/**
 * 响应对象接口
 * 实现该接口代表自身是一个响应对象
 */
public interface IResponse {

    /**
     * 响应的状态码
     * */
    int getCode();

    /**
     * 响应的描述信息
     * */
    String getMessage();
}
