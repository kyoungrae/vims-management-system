package com.management;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/cms")
public class ManagementController {

    @GetMapping("/page/load")
    public ResponseEntity<String> loadPage(@RequestParam("url") String url) {
        String resourcePath = "templates/page/" + url;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) return ResponseEntity.notFound().build();
            String html = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            return ResponseEntity.ok(html);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<!-- error loading -->");
        }
    }

}