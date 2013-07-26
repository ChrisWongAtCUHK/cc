package demo;

import cuhk.cse.*;

public class ProxyDemo {
	
	// http://openhome.cc/Gossip/SpringGossip/FromProxyToAOP.html
	public static void main(String[] args){
		IHandsome proxy = new HandsomeProxy(new HandsomeSpeaker());
		proxy.handsome("Chris Wong");
	}
}
