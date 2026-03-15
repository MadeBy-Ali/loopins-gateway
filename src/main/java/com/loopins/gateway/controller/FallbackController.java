package com.loopins.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/core")
    public ResponseEntity<Map<String, Object>> coreFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of(
                "success", false,
                "message", "Core service is temporarily unavailable. Please try again later.",
                "service", "loopins-core"
        ));
    }

    @GetMapping("/fulfillment")
    public ResponseEntity<Map<String, Object>> fulfillmentFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of(
                "success", false,
                "message", "Fulfillment service is temporarily unavailable. Please try again later.",
                "service", "loopins-fulfillment"
        ));
    }

    @GetMapping("/minio")
    public ResponseEntity<Map<String, Object>> minioFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of(
                "success", false,
                "message", "Media storage is temporarily unavailable. Please try again later.",
                "service", "minio"
        ));
    }
}
