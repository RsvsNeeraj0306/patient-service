package com.pm.patient_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = patients.stream()
            .map((p-> PatientMapper.tDto(p)))
            .toList();
        return patientResponseDTOs;

    }

    public PatientResponseDTO saveNewPaitent(PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.save(PatientMapper.tModel(patientRequestDTO));
        // You may want to return a DTO or the saved patient, adjust as needed
        return PatientMapper.tDto(patient);
    }



}
