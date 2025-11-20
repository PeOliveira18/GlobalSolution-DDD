package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.CurriculoNaoEncontradoException;
import com.example.Futurify.Model.Curriculo;
import com.example.Futurify.Repository.CurriculoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurriculoServiceTest {

    @Mock
    private CurriculoRepository curriculoRepository;

    @InjectMocks
    private CurriculoService curriculoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(curriculoRepository.findAll())
                .thenReturn(Arrays.asList(new Curriculo(), new Curriculo()));

        var lista = curriculoService.findAll();

        assertEquals(2, lista.size());
        verify(curriculoRepository, times(1)).findAll();
    }

    @Test
    void testFindById_Sucesso() {
        Curriculo curriculo = new Curriculo();
        curriculo.setId(1);

        when(curriculoRepository.findById(1))
                .thenReturn(Optional.of(curriculo));

        Curriculo result = curriculoService.findById(1);

        assertEquals(1, result.getId());
    }

    @Test
    void testFindById_NotFound() {
        when(curriculoRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(CurriculoNaoEncontradoException.class, () ->
                curriculoService.findById(1)
        );
    }

    @Test
    void testSave() {
        Curriculo curriculo = new Curriculo();
        curriculoService.save(curriculo);

        verify(curriculoRepository, times(1)).save(curriculo);
    }

    @Test
    void testDelete() {
        curriculoService.delete(1);
        verify(curriculoRepository, times(1)).deleteById(1);
    }
}
