package com.line.bot.application;


import static java.util.Collections.singletonList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class Application {
	

    @Autowired 
    private LineMessagingService lineMessagingService;

//    public static Path downloadedContentDir;

//    public static void main(String[] args) throws IOException {
////        downloadedContentDir = Files.createTempDirectory("line-bot");
//        SpringApplication.run(Application.class, args);
//    }
//
//    @EventMapping
//    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
//        System.out.println("event: " + event);
//        final BotApiResponse apiResponse = lineMessagingService
//                .replyMessage(new ReplyMessage(event.getReplyToken(),
//                                               singletonList(new TextMessage(event.getMessage().getText()))))
//                .execute().body();
//        System.out.println("Sent messages: " + apiResponse);
//    }
//
//    @EventMapping
//    public void defaultMessageEvent(Event event) {
//        System.out.println("event: " + event);
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        return new TextMessage(event.getMessage().getText());
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }

//	public static Path getDownloadedContentDir() {
//		return downloadedContentDir;
//	}
//
//	public static void setDownloadedContentDir(Path downloadedContentDir) {
//		Application.downloadedContentDir = downloadedContentDir;
//	}
    
    
}