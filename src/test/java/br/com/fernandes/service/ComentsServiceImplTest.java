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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComentsServiceImplTest {

    @InjectMocks
    private ComentsServiceImpl comentsService;

    @Mock
    ComentsClient client;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Se tiver um comentario espero que seja retornado uma lista com tamanho de 1")
    void getComents() {
        // Given
        ComentsResponse coment = new ComentsResponse(1,2, "nome 1", "nome@gmail.com", "body texto");
        List<ComentsResponse> listResult = new ArrayList<>();
        listResult.add(coment);
        // When
        when(client.getComents()).thenReturn(listResult);
        // Then
        assertEquals(1, listResult.size());
        assertEquals(2, coment.id());
        assertNotNull(coment.email());
        assertNotNull(coment.body());
    }
}