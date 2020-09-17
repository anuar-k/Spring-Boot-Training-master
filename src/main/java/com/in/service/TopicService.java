package com.in.service;

import com.in.controller.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicService {
    //инициализуем данные в ArrayList
    List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Alex", "Java"),
            new Topic("2", "Mike", "Javascript"),
            new Topic("3", "Justin", "Swift")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        for (Topic topic : topics) {
            if (topic.getId().equals(id)) {
                return topic;
            }
        }
        throw new NoSuchElementException();
    }

    //добавляем новую сущность
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    //обновляем сущность по id
    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    //удаляем сущность по id
    public void deleteTopic(String id) {
        ArrayList<Topic> toRemove = new ArrayList<>();

        for (Topic topic : topics) {
            if (topic.getId().equals(id)) {
                toRemove.add(topic);
            }
        }

        for (Topic topic : toRemove) {
            topics.remove(topic);
        }
    }
}