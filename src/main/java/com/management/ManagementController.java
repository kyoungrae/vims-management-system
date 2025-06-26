package com.management;

import com.system.common.util.message.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/cms")
public class ManagementController {
    private final MessageService messageService;

    public ManagementController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/page/load")
    @ResponseBody
    public String loadPage(@RequestParam("url") String url) {
        String resourcePath = "templates/page/" + url;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                return loadErrorPage();
            }
            var content = messageMatcher(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8),"ko");
            return content;
        } catch (IOException e) {
            return loadErrorPage();
        }
    }

    private String messageMatcher(String content,String lang){

        Pattern pattern = Pattern.compile("\\[Page\\.Message\\]\\.Message\\.Label\\.Array\\[\"(.*?)\"\\]");
        Matcher matcher = pattern.matcher(content);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);
            String message = messageService.getMessage(key, lang);
            matcher.appendReplacement(result, message);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    private String loadErrorPage() {
        String errorPagePath = "templates/page/common/404.html";
        try (InputStream errorStream = getClass().getClassLoader().getResourceAsStream(errorPagePath)) {
            if (errorStream == null) {
                return "<div>404 Page Not Found</div>";
            }
            return new String(errorStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "<div>404 Page Not Found</div>";
        }
    }

}