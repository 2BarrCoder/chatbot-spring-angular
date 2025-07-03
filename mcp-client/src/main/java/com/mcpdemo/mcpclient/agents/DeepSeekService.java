/*
package com.mcpdemo.mcpclient.agents;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class DeepSeekService {
    @Value("${deepseek.api.url}")
    private String apiUrl;

    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${deepseek.model}")
    private String model;

    public String getChatResponse(String userMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> request = new HashMap<>();
        request.put("model", model);
        request.put("messages", Collections.singletonList(Map.of(
                "role", "user",
                "content", userMessage
        )));
        request.put("temperature", 0.7);
        request.put("max_tokens", 1000);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                Map.class
        );

        return extractResponseContent(response.getBody());
    }

    private String extractResponseContent(Map<String, Object> response) {
        if (response == null || !response.containsKey("choices")) {
            return "Error: Invalid response from DeepSeek";
        }

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        if (choices.isEmpty()) return "No response generated";

        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
        return (String) message.get("content");
    }
}
*/