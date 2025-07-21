package tech.pierandrei.Stuglish.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class KeepAliveController {


    private static final Logger log = LoggerFactory.getLogger(KeepAliveController.class);

    @GetMapping
    public void keepAlive(){
        log.debug("Health successfully.");
    }
}
