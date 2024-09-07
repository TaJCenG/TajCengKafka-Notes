//package com.taj.kafka.orderproducer;
//
//import java.util.Properties;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//
///**
// * Hello world!
// */
//public class Sync {
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        //3 main properties
//        props.setProperty("bootstrap.servers", "localhost:9092");
//        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
//        
//        KafkaProducer <String, Integer> producer = new KafkaProducer<String, Integer>(props);
//        ProducerRecord<String, Integer> record = new ProducerRecord<>("OrderTopic", "Taj", 23);
//        
//        try {
//        	System.out.println("Message Sent SuccessFully");
//        RecordMetadata recordMetadata = producer.send(record).get(); //sync call waiting for the response
//        System.out.println("Message Sent SuccessFully");
//        System.out.println(recordMetadata.partition());
//        System.out.println(recordMetadata.offset());
//        }catch(Exception E){
//        	E.printStackTrace();
//        }finally {
//        	producer.close();
//        }
//    }
//}
