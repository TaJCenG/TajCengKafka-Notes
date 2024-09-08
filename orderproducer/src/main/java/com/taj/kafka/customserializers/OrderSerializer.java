package com.taj.kafka.customserializers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taj.kafka.orderproducer.Order;

public class OrderSerializer implements Serializer<Order> {

	@Override
	public byte[] serialize(String topic, Order order) {
		byte[] response = null;
		 ObjectMapper obj = new ObjectMapper();
		 try {
			 response = obj.writeValueAsString(order).getBytes();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return response;
	}

}
