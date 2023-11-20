package com.programming.techie.springredditclone.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.programming.techie.springredditclone.dto.PostResponse;
import com.programming.techie.springredditclone.mapper.PostMapper;
import com.programming.techie.springredditclone.model.Post;
import com.programming.techie.springredditclone.repository.PostRepository;
import com.programming.techie.springredditclone.repository.SubredditRepository;
import com.programming.techie.springredditclone.repository.UserRepository;

class PostServiceTest2 {
	
	 private final PostRepository postRepository = Mockito.mock(PostRepository.class);
	    private final SubredditRepository subredditRepository = Mockito.mock(SubredditRepository.class);
	    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
	    private final AuthService authService = Mockito.mock(AuthService.class);
	    private final PostMapper postMapper = Mockito.mock(PostMapper.class);
	
	

	@Test
	@DisplayName("should find post by id")
	void shouldFindPostById() {
		PostService postService = new PostService(postRepository, subredditRepository, userRepository, authService, postMapper);
		Post post = new Post(123L, "First Post", "http://url.site", "Test", 0, null, Instant.now(), null);
		PostResponse postResponse = new PostResponse(123L, "First Post", "http://url.site", "Test", "Test USer", "Test REditt", 0, 0, "1 Hr ago", false, false);
		
		Mockito.when(postRepository.getById(123L)).thenReturn(post);
		Mockito.when(postMapper.mapToDto(Mockito.any(Post.class))).thenReturn(postResponse);
		
		PostResponse actualResponse = postService.getPost(123L);
		
		Assertions.assertThat(actualResponse.getId()).isEqualTo(postResponse.getId());
		Assertions.assertThat(actualResponse.getPostName()).isEqualTo(postResponse.getPostName());
		
		
		
	}

}
