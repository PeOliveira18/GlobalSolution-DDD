package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.UsuarioNaoEncontradoException;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(usuarioRepository.findAll()).thenReturn(
                Arrays.asList(new Usuario(), new Usuario())
        );

        var result = usuarioService.findAll();

        assertEquals(2, result.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        Usuario usuario = new Usuario();
        usuario.setId(1);

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.findById(1);

        assertEquals(1, result.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(usuarioRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(UsuarioNaoEncontradoException.class, () -> {
            usuarioService.findById(1);
        });
    }

    @Test
    void testSave() {
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");

        usuarioService.save(usuario);

        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testDelete() {
        usuarioService.delete(1);
        verify(usuarioRepository, times(1)).deleteById(1);
    }
}
