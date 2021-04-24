package site.xiaobu.starter.common.exception.exception;

import lombok.Getter;
import site.xiaobu.starter.common.base.ApplicationException;
import site.xiaobu.starter.common.base.IResponse;

/**
 * 断言异常
 */
@Getter
public class AssertException extends ApplicationException {

    private IResponse response;

    public AssertException(IResponse response) {
        super(response.getMessage());
        this.response = response;
    }
}
