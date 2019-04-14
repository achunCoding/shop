package top.wycfight.shop.demo.dto;

/**
 * @author: wycfight@163.com
 * @description: 通用返回对象
 * @create: 2019-04-12 18:44
 * @modify By:
 **/
public class CommonResult<T> {
    /**
     * 成功时状态码
     */
    public static final int SUCCESS = 0;
    /**
     * 失败时状态码
     */
    public static final int FAILED = 1;
    /**
     * 数据校验失败状态码
     */
    public static final int VALIDATE_FAILED = 2;
    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    /**
     * 普通成功返回 带数据
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return success("操作成功", data);
    }

    /**
     * 普通成功返回 带信息和数据
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(String message, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(SUCCESS);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    /**
     * 普通成功返回
     */
    public static <T> CommonResult<T> success() {
        return success(null);
    }

    /**
     * 带有消息的返回 不返回数据
     *
     * @param message 消息
     * @return
     */
    public static <T> CommonResult<T> success(String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(SUCCESS);
        result.setMessage(message);
        return result;
    }

    /**
     * 普通失败提示信息
     *
     * @return
     */
    public static <T> CommonResult<T> failed() {
        return failed("操作失败");
    }

    /**
     * 普通失败错误信息提示
     *
     * @param message 信息
     * @return
     */
    public static <T> CommonResult<T> failed(String message) {
        return failed(FAILED, message);
    }

    /**
     * 普通失败状态码和信息提示
     *
     * @param code    状态码
     * @param message 信息
     * @return
     */
    public static <T> CommonResult<T> failed(int code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 参数验证失败使用
     *
     * @param message 错误信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return validateFailed(VALIDATE_FAILED, message);
    }

    /**
     * 参数验证失败使用
     *
     * @param code    状态码
     * @param message 错误信息
     */
    public static <T> CommonResult<T> validateFailed(int code, String message) {
        return failed(code,message);
    }

    /**
     * 获取：状态码
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置：状态码
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取：信息
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置：信息
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取：数据
     *
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置：数据
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }
}
