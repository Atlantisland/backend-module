package academy.everyonecodes.service;

import academy.everyonecodes.communication.TheFinalCountdownRunner;
import academy.everyonecodes.domain.Accumulation;
import academy.everyonecodes.repository.AccumulationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AccumulationManagerTest {

    @Autowired
    AccumulationManager accumulationManager;

    @MockBean
    AccumulationRepository accumulationRepository;

    @MockBean
    TheFinalCountdownRunner theFinalCountdownRunner;

    @Test
    void accumulateRunsForTheFirstTime(){
        Accumulation accumulation1 = new Accumulation();
        when(accumulationRepository.findAll()).thenReturn(List.of(accumulation1));

        accumulationManager.accumulate();

        verify(accumulationRepository).count();
        verify(accumulationRepository).save(accumulation1);

        verify(accumulationRepository).findAll();
        Accumulation accumulation2 = new Accumulation(accumulation1.getId(), 1);
        verify(accumulationRepository).save(accumulation2);
    }

    @Test
    void accumulateRunsAfterTheFirstTime() {
        Accumulation accumulation1 = new Accumulation("test", 0);
        when(accumulationRepository.count()).thenReturn(1L);
        when(accumulationRepository.findAll()).thenReturn(List.of(accumulation1));

        accumulationManager.accumulate();

        verify(accumulationRepository).count();
        verify(accumulationRepository).findAll();
        Accumulation accumulation2 = new Accumulation(accumulation1.getId(), 1);
        verify(accumulationRepository).save(accumulation2);
    }
}