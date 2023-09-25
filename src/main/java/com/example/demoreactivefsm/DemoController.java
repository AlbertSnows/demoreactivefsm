//package com.example.demoreactivefsm;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.Operation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.text.MessageFormat;
//
//@RestController
//@OpenAPIDefinition
//public class DemoController {
//    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
//
//    @Operation(summary = "Get Demos", description = "Get a greeting demo")
//    @GetMapping("/hello")
//    public String get() {
//        var me = MessageFormat.format("I am an error {0}, {1}", "demo", "fello");
//        logger.error(me, "e");
//        return "Demo";
//    }
//}
