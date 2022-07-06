package edu.miu.cs.cs425.studentmgmt.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.student.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.student.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.student.service.TranscriptService;

@Service
public class TranscriptServiceImpl implements TranscriptService{

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript addNewTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }
    
    @Override
   public Transcript getTranscriptById(Integer transcriptId){
       return transcriptRepository.findById(transcriptId).orElse(null);
   }
}
