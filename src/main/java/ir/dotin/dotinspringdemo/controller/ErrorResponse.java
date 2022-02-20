package ir.dotin.dotinspringdemo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class ErrorResponse {

    private int statusCode;
    private String message;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private ZonedDateTime time;

    public ErrorResponse(int statusCode, String message, ZonedDateTime time) {
        this.statusCode = statusCode;
        this.message = message;
        this.time = time;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public static final class ErrorResponseBuilder {
        private int statusCode;
        private String message;
        private ZonedDateTime time;

        private ErrorResponseBuilder() {
        }

        public static ErrorResponseBuilder anErrorResponse() {
            return new ErrorResponseBuilder();
        }

        public ErrorResponseBuilder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder withTime(ZonedDateTime time) {
            this.time = time;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(statusCode, message, time);
        }
    }
}
