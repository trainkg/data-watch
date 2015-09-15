package com.zsq.ons.demo;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;

public class ConsumerDemo {
	public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID_ZSQ_C001");
        properties.put(PropertyKeyConst.AccessKey, "4ouktuFcPSGMvzWB");
        properties.put(PropertyKeyConst.SecretKey, "680FBVeCF7iysSo5Zs4tKn8HAtHa5w");
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("DATA_T2", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}