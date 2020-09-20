package com.example.demo.task;

import com.example.demo.service.AppleTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private final AppleTreeService appleTreeService;

    @Autowired
    public ScheduledTask(AppleTreeService appleTreeService) {
        this.appleTreeService = appleTreeService;
    }

    @Scheduled(fixedRate = 5000)
    public void runTree() {
        appleTreeService.execute();
    }
}
