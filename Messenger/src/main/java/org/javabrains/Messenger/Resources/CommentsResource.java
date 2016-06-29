package org.javabrains.Messenger.Resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javabrains.Messenger.Model.MyComment;
import org.javabrains.Messenger.Service.CommentService;

public class CommentsResource {
	CommentService service = new CommentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<MyComment> getAllComments(@PathParam("messageId") int messageId) {
		return service.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public MyComment getComment(@PathParam("commentId") int commentId) {
		return service.getComment(commentId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MyComment addComment(@PathParam("messageId") int messageId, MyComment comment) {
		comment.setMessageId(messageId);
		return service.addComment(comment);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public MyComment editComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId, MyComment comment) {
		comment.setMessageId(messageId);
		comment.setCommentId(commentId);
		return service.editComment(commentId, comment);
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteAllComments(@PathParam("messageId") int messageId) {
		return service.deleteAllComments(messageId);
	}
	
	@DELETE
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public MyComment deleteComment(@PathParam("commentId") int commentId) {
		return service.deleteComment(commentId);
	}
}
