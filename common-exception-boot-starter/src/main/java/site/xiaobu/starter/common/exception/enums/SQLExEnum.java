package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.base.IResponse;
import site.xiaobu.starter.common.constant.HttpStatus;

/**
 * SQL 操作相关异常
 */
public enum SQLExEnum implements IResponse {

    DataAccessException(HttpStatus.INTERNAL_ERROR, "发生数据访问异常"),
    CleanupFailureDataAccessException(HttpStatus.INTERNAL_ERROR, "一项操作成功地执行，但在释放数据库资源时发生异常"),
    DataAccessResourceFailureException(HttpStatus.INTERNAL_ERROR, "数据访问资源彻底失败"),
    DataIntegrityViolationException(HttpStatus.INTERNAL_ERROR, "Insert或Update数据时违反了完整性"),
    DataRetrievalFailureException(HttpStatus.INTERNAL_ERROR, "某些数据不能被检测到"),
    DeadlockLoserDataAccessException(HttpStatus.INTERNAL_ERROR, "当前的操作因为死锁而失败"),
    IncorrectUpdateSemanticsDataAccessException(HttpStatus.INTERNAL_ERROR, "Update时发生某些没有预料到的情况"),
    InvalidDataAccessApiUsageException(HttpStatus.INTERNAL_ERROR, "一个数据访问的JAVA API没有正确使用"),
    invalidDataAccessResourceUsageException(HttpStatus.INTERNAL_ERROR, "错误使用数据访问资源"),
    OptimisticLockingFailureException(HttpStatus.INTERNAL_ERROR, "Java类型和数据类型不匹配"),
    UncategorizedDataAccessException(HttpStatus.INTERNAL_ERROR, "有错误发生,无法归类具体异常"),
    ;

    SQLExEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    private final String message;
    private final int code;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
