package com.taj.kafka.customserializers;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.taj.kafka.orderproducer.Order;

/**
 * Hello world!
 */
public class Async {
    public static void main(String[] args) {
        Properties props = new Properties();
        //3 main properties
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "com.taj.kafka.customserializers.OrderSerializer");
        
        KafkaProducer <String, Order> producer = new KafkaProducer<String, Order>(props);
        Order order = new Order();
        order.setCustomerName("Taj");
        order.setProduct("Human");
        order.setAge(23);
        ProducerRecord<String, Order> record = new ProducerRecord<>("OrderCTopic", order.getCustomerName(), order);
        
        try {
       producer.send(record); //Async not wait for the response      
        }catch(Exception E){
        	E.printStackTrace();
        }finally {
        	producer.close();
        }
    }
}



