package com.zsq.rabbitmq;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8913);
		while(true){
			Socket scoket = server.accept();
			Thread workthread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("13231");
				}
			});
			workthread.start();
			scoket.close();
		}
	}
}
