package org.javabrains.Messenger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javabrains.Messenger.Model.MyMessage;
import org.javabrains.Messenger.mockdb.MockDatabaseClass;

public class MessageService {
	
	private Map<Long,MyMessage> messages = MockDatabaseClass.getMessages();
	
	public MessageService() {
		//adding some initial entries
		messages.put(1L, new MyMessage(1L,"Hello world","sherlock"));
		messages.put(2L, new MyMessage(2L,"Hello London","sherlock"));
	}
	
	public List<MyMessage> getAllMessages() {
		return new ArrayList<MyMessage>(messages.values());
	}
	
	public MyMessage getMessage(Long id) {
		return messages.get(id);
	}
	
	public MyMessage addMessage(MyMessage msg) {
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public MyMessage updateMessage(MyMessage msg) {
		if(msg.getId() <= 0) {
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public MyMessage deleteMessage(Long id) {
		return messages.remove(id);
		//Note that if you delete message in between, the subsequent ids are not modified
		//therefore, when calculating new id, it may be the one already present in the map
	}
}
