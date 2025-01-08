package com.example.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.CopilotResponce.CopilotResponce;
import com.example.dto.Payload;
import com.example.dto.PayloadMessage;
import com.example.dto.User;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PostMessageController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(PostMessageController.class);

    @PostMapping("/postmessage")
    @ResponseBody
    public ResponseEntity<?> postmessage(@RequestHeader("X-GitHub-Token") String tokenForUser, @RequestBody Payload payload, HttpServletResponse response) {
        return handlePost(tokenForUser, payload, response);
    }

    public ResponseEntity<?> handlePost(@RequestHeader("X-GitHub-Token") String tokenForUser, @RequestBody Payload payload, HttpServletResponse response) {
        logger.debug("■■■　handlePost");
        User user = getGithubUser(tokenForUser);

        // Insert a special pirate-y system message in our message list.
        payload.getMessages().addAll(List.of(
        new PayloadMessage("system", "You are a helpful assistant that replies to user messages as if you were the Blackbeard Pirate.")
        ,new PayloadMessage("system", "Start every response with the user's name, which is @" + user.getLogin())
        ));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenForUser);
        headers.set("Content-Type", "application/json");

        HttpEntity<Payload> requestEntity = new HttpEntity<>(payload, headers);

        // githubcopilotからの返信を取得
        ResponseEntity<CopilotResponce> copilotLLMResponse = restTemplate.postForEntity(
                "https://api.githubcopilot.com/chat/completions",
                requestEntity,
                CopilotResponce.class
        );
        CopilotResponce responseBody = copilotLLMResponse.getBody();
        logger.debug("■■　response.StatusCode = " + copilotLLMResponse.getStatusCode().toString());
        logger.debug("■■　response = " + copilotLLMResponse.getBody());
String c = responseBody.getChoices().stream()
    .filter(content -> StringUtils.endsWithIgnoreCase(content.getMessage().getRole(), "assistant"))
    .map(m->m.getMessage().getContent())
    .collect(Collectors.joining());
        writeResponse(response, c);
        return ResponseEntity.ok(c);
    }

    private void writeResponse(HttpServletResponse response, String message) {
        try{
            try(OutputStream out = response.getOutputStream();){
                byte[] data = message.getBytes("UTF-8");
                out.write(data);
                out.flush();
            }
        }catch(Exception e){
            logger.error("■■■　Error writing response: " + e.getMessage());
        }
    }
        
    private User getGithubUser(String tokenForUser){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenForUser);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<User> userResponse = restTemplate.exchange(
            "https://api.github.com/user",
            HttpMethod.GET,
            entity,
            User.class
        );
        User user = userResponse.getBody();
        logger.debug("■■■　User: " + user.getLogin());
        return user;
    }
}
