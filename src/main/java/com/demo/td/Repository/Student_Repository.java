package com.demo.td.Repository;
import com.demo.td.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Student_Repository  extends JpaRepository<Student, Integer> {
}
