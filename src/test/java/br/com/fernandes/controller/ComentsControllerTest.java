package br.com.fernandes.controller;

import br.com.fernandes.service.dto.request.ComentsResponse;
import br.com.fernandes.service.interfaces.ComentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(ComentsController.class)
class ComentsControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private ObjectMapper objectMapper;

   @MockBean
   private ComentsService comentsService;  // Mocando o meu service da aplicação

    private List<ComentsResponse> coments;

    @BeforeEach
    public void setUp() {
        coments =  new ArrayList<>();
    }

    @Test
    @DisplayName("Validando uma lista de comentarios")
    void getComentsTest() throws Exception {
        // Given
        coments.add(new ComentsResponse(1, 1, "coments 1", "coments@gmail.com", "Body - coments"));
        // When
        when(comentsService.getComents()).thenReturn(coments);
        // Then
        mockMvc.perform(get("/jsonplaceholder-api/comments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].postId").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("coments 1"))
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia quando nao tiver comentários")
    public void retornaUmaListaVazia() throws Exception {
        // Given
        // When
        mockMvc.perform(get("/jsonplaceholder-api/comments"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(0));
        // Then
    }
}