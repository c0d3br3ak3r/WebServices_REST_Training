package org.javabrains.Messenger.Resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javabrains.Messenger.Model.MyMessage;
import org.javabrains.Messenger.Service.MessageService;

@Path("/messages")
public class MessageResource {
	
	private MessageService msg_service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<MyMessage> getMessages() {
		return msg_service.getAllMessages();
	}
	

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String getMessagesPost() {
		return "<h1>Hello world</h1>";
	}
}
