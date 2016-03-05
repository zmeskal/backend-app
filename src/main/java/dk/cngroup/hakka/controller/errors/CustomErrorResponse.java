package dk.cngroup.hakka.controller.errors;

import lombok.Data;

@Data
public class CustomErrorResponse {

    private String message;

    public CustomErrorResponse(String message) {
        this.message = message;
    }
}