package org.javabrains.Messenger.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyComment {
	int commentId;
	String comment;
	int messageId;
	
	MyComment() {
		
	}
	
	public MyComment(int commentId, String comment, int messageId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.messageId = messageId;
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	
}
