package pl.edu.pjatk.michalk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatServiceTest {
    @Mock
    private CatRepository repository;
    private AutoCloseable openMocks;
    private CatService catService;

    @BeforeEach
    public void init(){
        openMocks = MockitoAnnotations.openMocks(this);
        catService = new CatService(repository);
    }

    @AfterEach
    public void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    public void findFinds(){
        String name = "aron";
        Integer age = 5;

        Cat cat = new Cat(name,age);
        ArgumentCaptor<Cat> captor = ArgumentCaptor.forClass(Cat.class);
        when(repository.save(captor.capture())).thenReturn(cat);

        catService.add(cat);
        Mockito.verify(repository,Mockito.times(1))
                .save(Mockito.any());
        Cat catFromSaveCall = captor.getValue();
        assertEquals(cat, catFromSaveCall);
    }

}
