package org.javabrains.Messenger.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.javabrains.Messenger.Model.MyMessage;
import org.javabrains.Messenger.Service.MessageService;

@Path("/messages")
public class MessageResource {
	
	private MessageService msg_service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<MyMessage> getMessages(@QueryParam("limit") int limit) {
		if(limit > 0) {
			//make own map
			return msg_service.getAllMessagesLimit(limit);
		}
		return msg_service.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public MyMessage getMessage(@PathParam("messageId") long msgId) {
		return msg_service.getMessage(msgId);
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MyMessage addMessage(MyMessage msg) {
		return msg_service.addMessage(msg);
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MyMessage updateMessage(@PathParam("messageId") long msgId, MyMessage msg) {
		msg.setId(msgId);
		System.out.println(msgId);
		return msg_service.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public MyMessage deleteMessage(@PathParam("messageId") long id) {
		return msg_service.deleteMessage(id);
	}
	
	
	@POST
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String getMessagesPost() {
		return "<h1>Hello world</h1>";
	}
	
	@GET
	@Path("/test")
	public String testMessage() {
		return "This is just a test message";
	}
}
