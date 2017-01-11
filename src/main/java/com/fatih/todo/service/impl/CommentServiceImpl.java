package com.fatih.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatih.todo.entity.Comment;
import com.fatih.todo.entity.Todo;
import com.fatih.todo.entity.User;
import com.fatih.todo.repository.CommentRepository;
import com.fatih.todo.repository.TodoRepository;
import com.fatih.todo.repository.UserRepository;
import com.fatih.todo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	private CommentRepository commentRepository;
	private TodoRepository todoRepository;
	private UserRepository userRepository;
	
	
	
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository , TodoRepository todoRepository , UserRepository userRepository) {
		this.commentRepository=commentRepository;
		this.todoRepository=todoRepository;
		this.userRepository=userRepository;
	}


	@Override
	public Comment createComment() {
		Comment comment=new Comment();
		return comment;
	}


	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
		
	}


	@Override
	public List<Comment> findByTodoId(String todoId) {
		
		 Todo todo=todoRepository.findByTodoId(todoId);
		 List<Comment> comments=commentRepository.findByTodo(todo);
		
		return comments;
	}


	@Override
	public List<Comment> findByUserName(String userName) {
		
		User user=userRepository.findByUserName(userName);
		
		 
		 List<Comment> comments=commentRepository.findByUser(user);
		
		return comments;
	}


	@Override
	public Comment findByCommentId(String commentId) {
		
		
		return commentRepository.findByCommentId(commentId);
	}


	@Override
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
		
	}

}
