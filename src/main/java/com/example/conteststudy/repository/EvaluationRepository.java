package com.example.conteststudy.repository;

import com.example.conteststudy.domain.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EvaluationRepository extends JpaRepository<Evaluation, String> {

    @Override
    Optional<Evaluation> findById(String evaluation_id);
}
