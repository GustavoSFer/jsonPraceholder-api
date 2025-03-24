package br.com.fernandes.service;

import br.com.fernandes.core.client.PostClient;
import br.com.fernandes.service.dto.request.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    PostClient postClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Buscando a lista de posts")
    public void buscandoListaDePosts() {
        // Given
        List<PostResponse> postsList = List.of(
                new PostResponse(1,1, "new 1 post", "body post"),
                new PostResponse(1,2, "new 2 post", "body post")
        );

        // When
        when(postClient.getPosts()).thenReturn(postsList);
        List<PostResponse> posts = postClient.getPosts();

        // Then
        assertEquals(2, posts.size());
        assertEquals(1, posts.get(0).id());

        // Varificando se o metodo foi chamado 1 vez.
        verify(postClient, times(1)).getPosts();
    }

}
