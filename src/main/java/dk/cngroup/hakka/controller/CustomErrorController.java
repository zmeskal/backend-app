package dk.cngroup.hakka.controller;

import dk.cngroup.hakka.controller.routes.ErrorRoutes;
import dk.cngroup.hakka.entity.CustomErrorResponse;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.ws.rs.core.MediaType;

@RestController
public class CustomErrorController implements ErrorController {


    @RequestMapping(value = ErrorRoutes.UNKNOWN_ERROR, produces = MediaType.APPLICATION_JSON)
    public CustomErrorResponse error() {
        return new CustomErrorResponse("Something unexpected happened");
    }

    @RequestMapping(value = ErrorRoutes.NOT_AUTHORIZED, produces = MediaType.APPLICATION_JSON)
    public CustomErrorResponse unauthorized() {
        return new CustomErrorResponse("You have to login dude");
    }

    @RequestMapping(value = ErrorRoutes.NOT_FOUND, produces = MediaType.APPLICATION_JSON)
    public CustomErrorResponse notFound() {
        return new CustomErrorResponse("This is probably not what you are looking for");
    }

    @RequestMapping(value = ErrorRoutes.INTERNAL_ERROR, produces = MediaType.APPLICATION_JSON)
    public CustomErrorResponse internalServerError() {
        return new CustomErrorResponse("Something went wrong");
    }

    @Override
    public String getErrorPath() {
        return ErrorRoutes.UNKNOWN_ERROR;
    }
}
