package com.example.service1.contrller;

import com.example.service1.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ServiceOneController {



    @Autowired
    KafkaProducer kafkaProducer;


    @PutMapping("/sendMessage/{message}")
    public String getString(@PathVariable String message){
        kafkaProducer.sendMessage("default",message);
        System.out.println("kkkk");
        return "Message sent successfully";
    }
}
