package com.fusesource.fusebyexample;

import java.io.*;
import java.net.*;

class TCPClient{
	
 public static void main(String argv[]) throws Exception{

	 String sentence = null;
  	 String modifiedSentence;
  	 boolean clientUp = true;
  
	 BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
  	 Socket clientSocket = new Socket("localhost", 8888);
  	 DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  	 BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  	
	 while(clientUp = true){
		
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
  		modifiedSentence = inFromServer.readLine();
  		System.out.println("FROM SERVER: " + modifiedSentence);
		
  		if(modifiedSentence.equals("STOP")){
  			clientSocket.close();
  			System.out.println("Stopping TCP Client...");
  	  		System.exit(0);
  		}
			
	 }
 }
}