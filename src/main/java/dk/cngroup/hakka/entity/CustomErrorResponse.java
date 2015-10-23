package dk.cngroup.hakka.entity;

import lombok.Data;

@Data
public class CustomErrorResponse {

    private String message;

    public CustomErrorResponse(String message) {
        this.message = message;
    }
}