package br.com.fernandes.controller;

import br.com.fernandes.service.dto.request.PostResponse;
import br.com.fernandes.service.interfaces.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private PostService postService;

    private List<PostResponse> posts;

    @BeforeEach
    public void setUp() {
        posts = new ArrayList<>();
        }

    @Test
    @DisplayName("Verificando a lista de posts")
    public void testListandoTodoOsPosts() throws Exception {

        // Given
        // Mockando a resposta do service corretamente
        posts = List.of(new PostResponse(1, 1, "titulo post", "texto do post, falando sobre"),
                 new PostResponse(1, 2, "titulo post2", "texto do post, falando sobre o post 2")
        );

        //when
        Mockito.when(postService.getPosts()).thenReturn(posts);

        // then
        mockMvc.perform(get("/jsonplaceholder-api/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$[0].title").exists())
                .andExpect(jsonPath("$[0].body").isNotEmpty());
    }

    @Test
    @DisplayName("Buscando um post pelo sei id")
    public void testBucandoPostPeloId() throws Exception {
        // given
        PostResponse post = new PostResponse(3,5, "Novo post realizado", "Texto do novo post");

        // when
         Mockito.when(postService.getById("5")).thenReturn(post);

        // then
        mockMvc.perform(get("/jsonplaceholder-api/posts/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post.id()))
                .andExpect(jsonPath("$.title").isNotEmpty())
                .andExpect(jsonPath("$.body").value(post.body()));

    }
}
