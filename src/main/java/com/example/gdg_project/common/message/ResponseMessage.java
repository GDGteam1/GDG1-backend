package com.example.gdg_project.common.message;

import lombok.ToString;

@ToString
public class ResponseMessage {
    public static final String EXAMPLE = "메시지 예시입니다.";

    // Default
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String CREATED = "created";
    public static final String UPDATED = "updated";
    public static final String DELETED = "deleted";


}