package com.taj.kafka.com.orderConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.taj.kafka.com.customdeserializers.OrderDeSerializer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties props = new Properties();
        //3 main properties
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", OrderDeSerializer.class.getName());
        props.setProperty("group.id", "OrderGroup");
        
        KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(props);
      consumer.subscribe(Collections.singletonList("OrderCTopic"));
      
      ConsumerRecords<String, Order> records = consumer.poll(Duration.ofSeconds(20));
      
      for (ConsumerRecord<String, Order> record : records) {  //fore ctl+space
    	  
    	  String customerName = record.key();
    	  Order order = record.value();
		System.out.println("customerName" + customerName);
		System.out.println("Product " + order.getProduct());
;		System.out.println("Age " + order.getAge());
	}
      consumer.close();
      
    }
}
