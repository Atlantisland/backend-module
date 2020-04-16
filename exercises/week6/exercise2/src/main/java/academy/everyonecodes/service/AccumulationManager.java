package academy.everyonecodes.service;

import academy.everyonecodes.domain.Accumulation;
import academy.everyonecodes.repository.AccumulationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccumulationManager {

    private final AccumulationRepository accumulationRepository;

    public AccumulationManager(AccumulationRepository accumulationRepository) {
        this.accumulationRepository = accumulationRepository;
    }

    public void accumulate() {
        initializeIfFirstTime();
        Accumulation accumulation = getIncreasedAccumulation();
        accumulationRepository.save(accumulation);
        System.out.println("Times that the countdown went off: " + accumulation.getTimes());
    }

    private void initializeIfFirstTime() {
        if (accumulationRepository.count() == 0) {
            Accumulation accumulation = new Accumulation();
            accumulationRepository.save(accumulation);
        }
    }

    private Accumulation getIncreasedAccumulation() {
        Accumulation accumulation = accumulationRepository.findAll().get(0);
        int timesIncreased = accumulation.getTimes() + 1;
        accumulation.setTimes(timesIncreased);
        return accumulation;
    }
}

