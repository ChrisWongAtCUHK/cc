package demo;

import cuhk.cse.*;

public class ProxyDemo {
	
	// http://openhome.cc/Gossip/SpringGossip/FromProxyToAOP.html
	public static void main(String[] args){
		LogHandler logHandler = new LogHandler();
		
		IHandsome proxy = (IHandsome)logHandler.bind(new HandsomeSpeaker());
		proxy.handsome("Chris Wong");
	}
}
