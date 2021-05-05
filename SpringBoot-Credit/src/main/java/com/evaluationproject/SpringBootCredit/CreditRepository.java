package com.evaluationproject.SpringBootCredit;

import com.evaluationproject.SpringBootCredit.modelclasses.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
