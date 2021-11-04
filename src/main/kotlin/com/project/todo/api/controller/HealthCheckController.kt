package com.project.todo.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/health")
class HealthCheckController {
    @GetMapping("/check")
    fun healthCheck(): HealthCheckResponse {
        return HealthCheckResponse("OK")
    }
}

data class HealthCheckResponse(val message: String)

