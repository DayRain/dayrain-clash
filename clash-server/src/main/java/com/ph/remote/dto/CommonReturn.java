package com.ph.remote.dto;

import lombok.Data;

@Data
public class CommonReturn {
    private String status;

    private String message;

    private Object data;

    public void success(Object data){
        this.status = "Y";
        this.data = data;
    }
    public void success(Object data ,String message){
        this.status = "Y";
        this.data = data;
        this.message = message;
    }

    public void fail(String message){
        this.status = "N";
        this.message = message;
    }


}
