package demo.springboot.logger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/logger")
@Slf4j
public class LoggerController {
    @GetMapping("/info")
    public void info() {
        log.info("logger write info...");
    }

    @GetMapping("/warn")
    public void warn() {
        log.warn("logger write warn...");
    }

    @GetMapping("/error")
    public void error() {
        log.error("logger write warn...");
    }

    // 批量生成
    @GetMapping("/batch")
    public void batch() {
        for (int i=0; i<50000; i++) {
            log.info("logger write info...");
            log.warn("logger write warn...");
            log.error("logger write warn...");
        }
    }
}
