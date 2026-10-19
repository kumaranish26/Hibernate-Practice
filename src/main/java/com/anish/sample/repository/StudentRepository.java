package com.anish.sample.repository;

import com.anish.sample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository< Student,Long>
{

}
