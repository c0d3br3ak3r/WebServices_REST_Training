package org.javabrains.Messenger.mockdb;

import java.util.TreeMap;

import org.javabrains.Messenger.Model.MyComment;
import org.javabrains.Messenger.Model.MyMessage;

public class MockDatabaseClass {
	private static TreeMap<Long,MyMessage> messages = new TreeMap<Long,MyMessage>();
	private static TreeMap<Long,MyComment> comments = new TreeMap<Long,MyComment>();
	
	public static TreeMap<Long,MyMessage> getMessages() {
		return messages;
	}
	
	public static TreeMap<Long,MyComment> getComments() {
		return comments;
	}
	
}
