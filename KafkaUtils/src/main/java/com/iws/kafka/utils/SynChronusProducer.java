package com.iws.kafka.utils;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class SynChronusProducer {

	public static void main(String[] args) throws Exception {

		String topicName = "MyTestXYZ";
		String key = "Key1";
		String value = "Value-1";

		Properties props = new Properties();
		props.put("bootstrap.servers","localhost:9091;localhost:9092,localhost:9093");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

		
		
		/*
		  Kafak Supports Different Serilalizers (key.serializer and
		  value.serializer) i)IntSerilalizer ii)StringSerilizer
		  iii)DoubleSerilizer
		 */
		
		// Kafa Producer object
		Producer<String, String> producer = new KafkaProducer(props);
		
		
		for(int i=0;i<10;i++){
		// Kafka Producer Record object  (topicName,Key and Value)
		ProducerRecord<String, String> record = new ProducerRecord(topicName,	String.valueOf(key+i), String.valueOf(value+"_"+i));
		RecordMetadata rd= producer.send(record).get();
		System.out.println("Message is sent to Partition No:"+rd.partition()+" and OffSet "+rd.offset());
		
		}
		
		producer.close();
		System.out.println("SimpleProducer Completed.");
	}
}
