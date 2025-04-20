package br.com.fernandes.client.adapter;

import br.com.fernandes.client.ComentsFeignClient;
import java.util.Arrays;
import br.com.fernandes.service.dto.request.ComentsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("ComentsHttpCliente")
class ComentsHttpClienteTest {

    @Mock
    private ComentsFeignClient feignClient;

    @InjectMocks
    private ComentsHttpCliente httpCliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private List<ComentsResponse> list;

    @Test
    @DisplayName("Validando a busca dos comentarios")
    void getComents() {
        // Given
        list = Arrays.asList(
                new ComentsResponse(1,1,"title 1", "email@gmail.com", "Coments 1"),
                new ComentsResponse(1,2,"title 2", "email2@gmail.com", "Coments 2")
                );
        // When
        when(feignClient.getComents()).thenReturn(list);
        List<ComentsResponse> resultList = httpCliente.getComents();
        // Then
        assertEquals(2, resultList.size());
        assertEquals(1, resultList.get(0).postId());
        assertEquals(1, resultList.get(0).id());
        assertEquals("title 1", resultList.get(0).name());
    }

    @Test
    @DisplayName("Validando lista vazia quando não tiver comentarios")
    public void getCoemntsListaVazia() {
        //Given
        //Wen
        when(feignClient.getComents()).thenReturn(List.of());
        List<ComentsResponse> list = httpCliente.getComents();
        //Then
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Validando retorno null em caso de erro")
    public void getComentsNullErro() {
        //Given
        //When
        when(feignClient.getComents()).thenThrow(RuntimeException.class);
        List<ComentsResponse> list = httpCliente.getComents();
        //Then
        assertNull(list);
    }
}