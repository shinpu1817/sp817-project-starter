package top.sp817.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Res<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private String info;
    private Long timestamp;
    public static final String token = "AuthStr";
    public static final int SUCCESS = 200;
    public static final int SERVICE_ERROR = 400;
    public static final int LOGIN_ERROR = 401;
    public static final int TIME_ERROR = 402;
    public static final int AUTH_ERROR = 403;
    public static final int RN_ERROR = 404;
    public static final int HOST_ERROR = 500;

    public static <T> Res<T> Create(T data) {
        return new Res<>(SUCCESS, "操作成功", data, null, System.currentTimeMillis());
    }

    public static <T> Res<T> Create(T data, String msg) {
        return new Res<>(SUCCESS, msg, data, null,System.currentTimeMillis());
    }

    public static <T> Res<T> Error(Integer code, String msg) {
        return new Res<>(code, msg, null, null,System.currentTimeMillis());
    }

    public static Res<?> GlobalExceptionRes(int code, String message) {
        return new Res<>(code, message, null, null,System.currentTimeMillis());
    }


}