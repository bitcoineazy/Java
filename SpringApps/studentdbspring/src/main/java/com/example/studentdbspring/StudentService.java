package com.example.studentdbspring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@Transactional
public class StudentService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Student WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}