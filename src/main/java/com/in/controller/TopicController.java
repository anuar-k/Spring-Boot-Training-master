package com.in.controller;

import com.in.service.TopicService;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TopicController {
    //сервис для Topic
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    //получаем список всех сущностей
    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    //получаем сущность по id с помощью сервиса
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    //получаем новую сущность и добавляем ее с помощью сервиса
    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    //получаем новую сущность и обновляем ее с помощью сервиса
    @PutMapping(value = "topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    //удаляем сущность по id с помощью сервиса
    @DeleteMapping(value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}