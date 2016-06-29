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
		// why is it getting initialized everytime ????
		messages.put(1L, new MyMessage(1L,"Hello world","sherlock"));
		messages.put(2L, new MyMessage(2L,"Hello London","sherlock"));
	}
	
	public List<MyMessage> getAllMessages() {
		return new ArrayList<MyMessage>(messages.values());
	}
	
	public List<MyMessage> getAllMessagesLimit(int limit) {
		List<MyMessage> list = new ArrayList<MyMessage>();
		for(int i=1;i<=limit;i++) {
			MyMessage msg = messages.get((long)i);
			if(msg != null) {
				list.add(msg);
			} else {
				break;
			}
		}
		return list;
	}
	
	public MyMessage getMessage(Long id) {
		return messages.get(id);
	}
	
	public MyMessage addMessage(MyMessage msg) {
		Object[] messageIds = (messages.keySet()).toArray();
		long messageId = ((long) messageIds[messages.size()-1]);
		msg.setId(messageId+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public MyMessage updateMessage(MyMessage msg) {
		messages.put(msg.getId(), msg);
		System.out.println("OMG " + msg.getId());
		return msg;
	}
	
	public MyMessage deleteMessage(Long id) {
		return messages.remove(id);
		//Note that if you delete message in between, the subsequent ids are not modified
		//therefore, when calculating new id, it may be the one already present in the map
	}
}
