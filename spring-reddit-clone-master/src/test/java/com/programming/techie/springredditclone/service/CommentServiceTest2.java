package com.programming.techie.springredditclone.service;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.programming.techie.springredditclone.exceptions.SpringRedditException;

public class CommentServiceTest2 {

	@Test
	@DisplayName("Test shold pass when comment doesnot contain swear words")
	void shouldnotContainsSwearWords() {
		CommentService commentService= new CommentService(null, null, null, null, null, null, null);
		Assertions.assertFalse(commentService.containsSwearWords("This is a clean comment"));
	}
	
	@Test
	@DisplayName("Test should pass when comment contain swear words")
	void shouldFailContainsSwearWords() {
		CommentService commentService= new CommentService(null, null, null, null, null, null, null);
		SpringRedditException exception =assertThrows(SpringRedditException.class, ()->{
			commentService.containsSwearWords("This is a shit comment");	
		});
		
		assertTrue(exception.getMessage().contains("Comments contains unacceptable language"));
	}

}
