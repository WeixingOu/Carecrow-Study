package com.std.carecrow.exception.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.std.carecrow.exception.constant.HttpStatus;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private final int code;
    private final String message;
    private final T data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Map<String, Object> additionalFields;

    private ApiResponse(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
        this.additionalFields = builder.additionalFields;
    }

    public static <T> ApiResponse<T> success() {
        return new Builder<T>().code(HttpStatus.SUCCESS).message("Operation completed successfully").build();
    }

    public static <T> ApiResponse<T> success(String message) {
        return new Builder<T>().code(HttpStatus.SUCCESS).message(message).build();
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new Builder<T>().code(HttpStatus.SUCCESS).message(message).data(data).build();
    }

    public static <T> ApiResponse<T> warn(String message) {
        return new Builder<T>().code(HttpStatus.WARN).message(message).build();
    }

    public static <T> ApiResponse<T> warn(String message, T data) {
        return new Builder<T>().code(HttpStatus.WARN).message(message).data(data).build();
    }

    public static <T> ApiResponse<T> error(String message) {
        return new Builder<T>().code(HttpStatus.ERROR).message(message).build();
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new Builder<T>().code(HttpStatus.ERROR).message(message).data(data).build();
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new Builder<T>().code(code).message(message).build();
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == HttpStatus.SUCCESS;
    }
    @JsonIgnore
    public boolean isWarning() {
        return this.code == HttpStatus.WARN;
    }
    @JsonIgnore
    public boolean isError() {
        return this.code == HttpStatus.ERROR || (this.code >= HttpStatus.BAD_REQUEST && this.code < HttpStatus.ERROR);
    }

    public static class Builder<T> {
        private int code;
        private String message;
        private T data;
        private final Map<String, Object> additionalFields = new HashMap<>();

        public Builder<T> code(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> addField(String key, Object value) {
            this.additionalFields.put(key, value);
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(this);
        }
    }
}


