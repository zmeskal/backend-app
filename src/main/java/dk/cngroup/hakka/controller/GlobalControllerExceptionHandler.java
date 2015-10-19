package dk.cngroup.hakka.controller;

import dk.cngroup.hakka.entity.CustomErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;


@ControllerAdvice
class GlobalControllerExceptionHandler {

    /**
     *
     * @param exception
     * @return exception message
     *
     * Returned when DataIntegrityViolationException thrown from anywhere.
     * Usage: throw new DataIntegrityViolationException("Item already exists");
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    @RequestMapping(value = "/409", produces = MediaType.APPLICATION_JSON)
    public CustomErrorResponse handleConflict(DataIntegrityViolationException exception) {
        return new CustomErrorResponse(exception.getMessage());
    }
}