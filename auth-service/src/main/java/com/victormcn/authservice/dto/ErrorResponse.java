package com.victormcn.authservice.dto;

public class ErrorResponse {

    private int status;
    private String erro;

    public ErrorResponse(int status, String erro) {
        this.status = status;
        this.erro = erro;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }
}