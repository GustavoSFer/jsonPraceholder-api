package br.com.fernandes.controller;

import br.com.fernandes.service.dto.request.PostResponse;
import br.com.fernandes.service.interfaces.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
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
        given(postService.getPosts()).willReturn(List.of(
                new PostResponse(1, 1, "titulo post", "texto do post, falando sobre"),
                new PostResponse(1, 2, "titulo post2", "texto do post, falando sobre o post 2")
        ));

        //when
        ResultActions result = mockMvc.perform(get("/posts"));

        // then
        result.andExpect(status().isOk())
                .andDo(print());
    }
}
