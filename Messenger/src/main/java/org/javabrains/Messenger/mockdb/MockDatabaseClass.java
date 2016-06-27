package org.javabrains.Messenger.mockdb;

import java.util.HashMap;
import java.util.Map;

import org.javabrains.Messenger.Model.MyMessage;

public class MockDatabaseClass {
	private static Map<Long,MyMessage> messages = new HashMap<Long,MyMessage>();
	
	public static Map<Long,MyMessage> getMessages() {
		return messages;
	}
	
}
