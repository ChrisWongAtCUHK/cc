package cuhk.cse;

public class HandsomeSpeaker implements IHandsome {

	public void handsome(String name) throws Throwable {
		System.out.println(name + " is handsome.");

        throw new Exception("Derek is approaching, µo¥Í¨Ò¥~...");
	}
}
