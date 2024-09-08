package com.taj.kafka.com.customdeserializers;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taj.kafka.com.orderConsumer.Order;

public class OrderDeSerializer implements Deserializer<Order> {

	@Override
	public Order deserialize(String topic, byte[] data) {
		ObjectMapper obj = new ObjectMapper();
		Order order = null;
		try {
			order = obj.readValue(data, Order.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
