package academy.everyonecodes.service;

import academy.everyonecodes.communication.TheFinalCountdownRunner;
import academy.everyonecodes.domain.Countdown;
import academy.everyonecodes.repository.CountdownRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CountdownManagerTest {

    @Autowired
    CountdownManager countdownManager;

    @MockBean
    CountdownRepository countdownRepository;

    @MockBean
    AccumulationManager accumulationManager;

    @MockBean
    TheFinalCountdownRunner theFinalCountdownRunner;

    @Value("${countdown.start}")
    int countdownStart;

    @Test
    void countCreatesCountdown(){
        countdownManager.countdown();

        verify(countdownRepository).count();
        Countdown countdown = new Countdown(countdownStart);
        verify(countdownRepository).save(countdown);
        verify(countdownRepository, never()).findAll();
        verify(countdownRepository, never()).delete(countdown);
        verify(accumulationManager, never()).accumulate();
    }

    @Test
    void countReducesCountdown(){
        Countdown countdown1 = new Countdown(2);
        when(countdownRepository.count()).thenReturn(1L);
        when(countdownRepository.findAll()).thenReturn(List.of(countdown1));

        verify(countdownRepository).count();
        verify(countdownRepository).findAll();
        Countdown countdown2 = new Countdown(2);
        verify(countdownRepository).save(countdown2);
        verify(accumulationManager, never()).accumulate();
    }

    @Test
    void countRemovesCountdown(){
        Countdown countdown1 = new Countdown(1);
        when(countdownRepository.count()).thenReturn(1L);
        when(countdownRepository.findAll()).thenReturn(List.of(countdown1));

        countdownManager.countdown();

        verify(countdownRepository).count();
        verify(countdownRepository).findAll();
        Countdown countdown2 = new Countdown(0);
        verify(countdownRepository, never()).save(countdown2);
        verify(countdownRepository).delete(countdown2);
        verify(accumulationManager).accumulate();
    }
}