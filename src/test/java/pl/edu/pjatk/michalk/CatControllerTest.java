package pl.edu.pjatk.michalk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CatControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CatService catService;

    @InjectMocks
    private MyRestController controller;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new CatExceptionHandler(), controller).build();
    }

//    @Test
//    public void getByIdReturns200WhenPersonIsPresent() throws Exception{
//        Cat cat = new Cat("aron",12);
//        when(catService.findById(3L)).thenReturn(cat);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/cat/id/3"))
//                .andExpect(jsonPath("$.name").value("aron"))
//                .andExpect(jsonPath("$.age").value(12))
//                .andExpect(status().isOk());
//    }
}
