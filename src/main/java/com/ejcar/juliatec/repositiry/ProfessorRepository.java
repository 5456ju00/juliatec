package com.ejcar.juliatec.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejcar.juliatec.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
