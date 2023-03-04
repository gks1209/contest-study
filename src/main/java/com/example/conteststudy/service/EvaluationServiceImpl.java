package com.example.conteststudy.service;

import com.example.conteststudy.domain.dto.EvaluationDto;
import com.example.conteststudy.repository.EvaluationRepository;

public class EvaluationServiceImpl implements EvaluationService{

    private final EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public void save(EvaluationDto evaluationDto) {

        evaluationRepository.save(evaluationDto.toEntity());

    }
}
