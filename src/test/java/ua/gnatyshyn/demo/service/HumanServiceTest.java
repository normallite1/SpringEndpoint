package ua.gnatyshyn.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.gnatyshyn.demo.Entity.Human;
import ua.gnatyshyn.demo.repo.HumanRepos;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class HumanServiceTest {
    @Mock
    private HumanRepos humanRepos;

    @InjectMocks
    private HumanService humanService;

    @Test
    public void shouldReturnHuman(){
        Human human = new Human("Kostia", "Gnatyshyn", "1997.07.31");
        Mockito.when(humanRepos.findById(human.getId())).thenReturn(Optional.of(human));
        Human beforeHuman = humanService.findById(human.getId()).get();

        Assertions.assertNotNull(beforeHuman);
        Assertions.assertEquals(beforeHuman, human);
        Assertions.assertEquals("25", beforeHuman.getYears());

    }
}
