package org.javabrains.Messenger.Service;

import java.util.ArrayList;
import java.util.TreeMap;

import org.javabrains.Messenger.Model.MyComment;
import org.javabrains.Messenger.mockdb.MockDatabaseClass;

public class CommentService {
	
	private TreeMap<Long, MyComment> comments = MockDatabaseClass.getComments();
	
	public CommentService() {
		comments.put(1L, new MyComment(1, "Comment1", 1));
		comments.put(2L, new MyComment(2, "Comment1", 1));
	}
	
	public MyComment getComment(int commentId) {
		return comments.get((long) commentId);
	}
	
	public MyComment addComment(MyComment comment) {
		Object[] commentIdArr = (comments.keySet()).toArray();
		int commentId = ((Long)commentIdArr[comments.size()-1]).intValue();
		comment.setCommentId(commentId + 1);
		comments.put((long) comment.getCommentId(), comment);
		return comment;
	}
	
	public MyComment editComment(int commentId, MyComment comment) {
		comments.put((long) commentId, comment);
		return comment;
	}
	
	public boolean deleteAllComments(int messageId) {
		for(Long i : comments.keySet()) {
			MyComment curr_comment = comments.get(i);
			if(curr_comment.getMessageId() == messageId) {
				comments.remove((long)curr_comment.getCommentId());
			}
		}
		return true;
	}
	
	public MyComment deleteComment(int commentId) {
		MyComment comment = comments.get((long) commentId); 
		comments.remove((long) commentId);
		return comment;
	}
	
	public ArrayList<MyComment> getAllComments(int messageId) {
		ArrayList<MyComment> list = new ArrayList<MyComment>();
		for(Long i : comments.keySet()) {
			MyComment curr_comment = comments.get(i);
			if(curr_comment.getMessageId() == messageId) {
				list.add(curr_comment);
			}
		}
		return list;
	}
	
}
