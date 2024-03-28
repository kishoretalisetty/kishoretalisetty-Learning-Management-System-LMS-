package org.example.RepositoryLayer;

import org.example.EntityLayer.StudentEnrollSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollSubjectRepository extends JpaRepository<StudentEnrollSubject, Integer> {
}
