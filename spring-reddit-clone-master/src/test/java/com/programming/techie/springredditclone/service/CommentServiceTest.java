package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.exceptions.SpringRedditException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommentServiceTest {
	
    @Test
    @DisplayName("Test Should Pass When Comment do not Contains Swear Words")
    void shouldNotContainSwearWordsInsideComment1() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
        Assertions.assertFalse(commentService.containsSwearWords("This is a comment"));
    }
	
    @Test
    @DisplayName("Test Should fail When Comment Contains Swear Words")
    void shouldFailWhenCommentContainSwearWords() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
        SpringRedditException exception = assertThrows(SpringRedditException.class, ()->{
        	commentService.containsSwearWords("This is shitty comment");
        });
        
        assertTrue(exception.getMessage().contains("Comments contains unacceptable language"));
    }
    
    /*Assert J*/
    @Test
    @DisplayName("Test Should Pass When Comment do not Contains Swear Words")
    void shouldNotContainSwearWordsInsideComment() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
        assertThat(commentService.containsSwearWords("This is a comment")).isFalse();
    }

    @Test
    @DisplayName("Should Throw Exception when Exception Contains Swear Words")
    void shouldFailWhenCommentContainsSwearWords() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);

        assertThatThrownBy(() -> {
            commentService.containsSwearWords("This is a shitty comment");
        }).isInstanceOf(SpringRedditException.class)
                .hasMessage("Comments contains unacceptable language");
    }
}


