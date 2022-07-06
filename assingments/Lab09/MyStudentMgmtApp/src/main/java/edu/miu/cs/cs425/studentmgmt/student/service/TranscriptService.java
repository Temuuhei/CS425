package edu.miu.cs.cs425.studentmgmt.student.service;

import edu.miu.cs.cs425.studentmgmt.student.model.Transcript;

public interface TranscriptService {
    
    Transcript addNewTranscript(Transcript transcript);

    Transcript getTranscriptById(Integer transcriptId);
}
