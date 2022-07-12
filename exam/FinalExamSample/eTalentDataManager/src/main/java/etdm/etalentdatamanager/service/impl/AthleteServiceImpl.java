package etdm.etalentdatamanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etdm.etalentdatamanager.model.Athlete;
import etdm.etalentdatamanager.service.AthleteService;
import etdm.etalentdatamanager.repository.AthleteRepository;

import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Athlete addNewAthlete(Athlete athlete) {
        var newAthlete = athleteRepository.save(athlete);
        return newAthlete;
    }

    @Override
    public List<Athlete> getAllAthletes() {
        var athletes = athleteRepository.getAllAthletes();
        return athletes;

    }

    @Override
    public  List<Athlete> getAllEliteAthletes() {
        var eliteAthletes = athleteRepository.getAllEliteAthletesByFullNameAsc();
        return eliteAthletes;
    }

}

