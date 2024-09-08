package com.Ecommerce.Ecommerce.application.documentation.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "API Response Wrapper")
public class CoreApiResponse<T> {
    @Schema(description = "Response message")
    private String message;

    @Schema(description = "Response status code")
    private Integer code;

    @Schema(description = "Response data", nullable = true)
    private T data;

    public CoreApiResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static <T> CoreApiResponse<T> success(String message,Integer code,T data){
        CoreApiResponse<T> newResponse=new CoreApiResponse<>();
        newResponse.setMessage(message);
        newResponse.setCode(code);
        newResponse.setData(data);
        return newResponse;
    }
    public static CoreApiResponse<?> success(String message,Integer code){
        CoreApiResponse<?> newResponse=new CoreApiResponse<>();
        newResponse.setMessage(message);
        newResponse.setCode(code);
        return newResponse;
    }
    public static CoreApiResponse<?> success(){
        CoreApiResponse<?> newResponse=new CoreApiResponse<>();
        newResponse.setMessage("Success");
        newResponse.setCode(200);
        return newResponse;
    }

    public static <T> CoreApiResponse<T> error(String message,Integer code,T data){
        CoreApiResponse<T> newResponse=new CoreApiResponse<>();
        newResponse.setMessage(message);
        newResponse.setCode(code);
        newResponse.setData(data);
        return newResponse;
    }
    public static CoreApiResponse<?> error(String message,Integer code){
        CoreApiResponse<?> newResponse=new CoreApiResponse<>();
        newResponse.setMessage(message);
        newResponse.setCode(code);
        return newResponse;
    }
    public static CoreApiResponse<?> error(){
        CoreApiResponse<?> newResponse=new CoreApiResponse<>();
        newResponse.setMessage("Internal Server Error");
        newResponse.setCode(500);
        return newResponse;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
