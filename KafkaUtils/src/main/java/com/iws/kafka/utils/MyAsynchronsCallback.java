package com.iws.kafka.utils;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MyAsynchronsCallback implements Callback {

	public void onCompletion(RecordMetadata arg0, Exception arg1) {

		if (arg1 != null) {
			System.out
					.println("MyAsynchronsCallback Failed with an exception ");
		}

		else {

			System.out.println("MyAsynchronsCallback Call Success");
		}
	}

}
