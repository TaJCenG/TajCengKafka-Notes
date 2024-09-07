package com.taj.kafka.orderproducer;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Hello world!
 */
public class Async {
    public static void main(String[] args) {
        Properties props = new Properties();
        //3 main properties
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        
        KafkaProducer <String, Integer> producer = new KafkaProducer<String, Integer>(props);
        ProducerRecord<String, Integer> record = new ProducerRecord<>("OrderTopic", "Taj", 23);
        
        try {
       producer.send(record,new OrderCallback()); //Async not wait for the response      
        }catch(Exception E){
        	E.printStackTrace();
        }finally {
        	producer.close();
        }
    }
}



