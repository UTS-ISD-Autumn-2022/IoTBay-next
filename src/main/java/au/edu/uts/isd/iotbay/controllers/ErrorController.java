package au.edu.uts.isd.iotbay.controllers;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {
    final Logger log = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    public String errorGet(HttpServletRequest req, Exception ex) {
        log.error("Server Exception was caught!", ex);

        val errorCode = (int) req.getAttribute("javax.servlet.error.status_code");
        switch (errorCode) {
            case 400:
                return "error/400";
            case 403:
                return "error/403";
            case 404:
                return "error/404";
        }

        return "error/500";
    }
}
