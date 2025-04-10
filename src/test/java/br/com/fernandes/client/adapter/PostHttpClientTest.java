package br.com.fernandes.client.adapter;

import br.com.fernandes.client.PostFeignClient;
import br.com.fernandes.service.dto.request.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PostHttpClientTest {

    @Mock
    private PostFeignClient client;

    @InjectMocks
    private PostHttpClient httpClient;

    private List<PostResponse> posts;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve retornar todos os posts quando existir")
    void getPostsTest() {
        // Given
        posts = Arrays.asList(
                new PostResponse(1,1,"title", "body"),
                new PostResponse(1,2,"title 2", "body 2")
        );
        // When
        when(client.getPosts()).thenReturn(posts);

        List<PostResponse> resultPosts = httpClient.getPosts();
        // Then
        assertEquals(2, resultPosts.size());
        assertEquals("title", resultPosts.get(0).title());
        assertEquals("body", resultPosts.get(0).body());
    }

    @Test
    @DisplayName("Deve retornar uma exception quando ocorrer algum erro")
    public void getPostExceptionTest() {
        // Given

        // When
        when(client.getPosts()).thenThrow(new RuntimeException("Run time"));
        List<PostResponse> result = httpClient.getPosts();
        // Then
        assertNull(result);
    }

    @Test
    void getById() {
    }
}