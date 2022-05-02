package au.edu.uts.isd.iotbay:

    import org.springframework.stereotype.Controller
    import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    class CustomerController():
        @GetMapping("/register")
        def registerGet () = "register"