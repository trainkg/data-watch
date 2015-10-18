package com.zsq.rabbitmq;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.ws.rs.client.Client;

public class BaseScoket {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.199.211",8913);
			socket.getOutputStream().write(1);
			socket.getOutputStream().flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
