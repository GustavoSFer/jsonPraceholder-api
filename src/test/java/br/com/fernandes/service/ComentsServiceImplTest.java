package br.com.fernandes.service;

import br.com.fernandes.core.client.ComentsClient;
import br.com.fernandes.service.dto.request.ComentsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComentsServiceImplTest {

    @InjectMocks
    private ComentsServiceImpl comentsService;

    @Mock
    ComentsClient client;

    private List<ComentsResponse> mockComentsList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ComentsResponse coment1 = new ComentsResponse(1, 1, "nome 1", "nome@gmail.com", "Coment 1");
        ComentsResponse coment2 = new ComentsResponse(1, 2, "nome 2", "nome@gmail.com", "Coment 2");
        mockComentsList = Arrays.asList(coment1, coment2);
    }

    @Test
    @DisplayName("Deve retorna uma lista de comentarios quando tiver")
    void getComents() {
        // Given
        // When
        when(client.getComents()).thenReturn(mockComentsList);

        List<ComentsResponse> listResult = comentsService.getComents();
        // Then
        assertEquals(2, listResult.size());
        assertEquals(1, listResult.get(0).postId());
        assertNotNull(listResult.get(0).body());
        assertEquals("Coment 1", listResult.get(0).body());
        assertEquals("Coment 2", listResult.get(1).body());
    }
}