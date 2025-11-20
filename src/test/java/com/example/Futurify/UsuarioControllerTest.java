package com.example.Futurify.Controller;

import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFindAll_NoContent() throws Exception {
        Mockito.when(usuarioService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/usuarios/all"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testFindAll_Success() throws Exception {
        Usuario u = new Usuario();
        u.setId(1);
        u.setNome("Pedro");
        u.setEmail("teste@mail.com");

        Mockito.when(usuarioService.findAll()).thenReturn(Collections.singletonList(u));

        mockMvc.perform(get("/usuarios/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Pedro"));
    }

    @Test
    void testPostUsuario_Success() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setEmail("pedro@mail.com");

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated());
    }

    @Test
    void testPostUsuario_IdNaoAceito() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Pedro");

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testDeleteUsuario() throws Exception {
        Mockito.doNothing().when(usuarioService).delete(1);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isOk());
    }
}
