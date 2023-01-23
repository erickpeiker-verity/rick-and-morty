package br.com.verity.rickandmorty;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonagensApiIntegrationTest {
    private static final String PETS_PATH = "/personagens/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenReadAll_thenStatusIsNotImplemented() throws Exception {
        this.mockMvc.perform(get(PETS_PATH)).andExpect(status().isNotImplemented());
    }

    @Test
    public void whenReadOne_thenStatusIsNotImplemented() throws Exception {
        this.mockMvc.perform(get(PETS_PATH + 1)).andExpect(status().isNotImplemented());
    }
}
