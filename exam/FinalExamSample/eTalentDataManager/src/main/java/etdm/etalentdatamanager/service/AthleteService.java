package etdm.etalentdatamanager.service;

import etdm.etalentdatamanager.model.Athlete;
import java.util.List;


public interface AthleteService {

    Athlete addNewAthlete(Athlete athlete);

    List<Athlete> getAllAthletes();

    List<Athlete> getAllEliteAthletes();
}