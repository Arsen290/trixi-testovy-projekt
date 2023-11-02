package cz.project.trixitest.repository;

import cz.project.trixitest.models.Obec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObecRepository extends JpaRepository<Obec, Integer> {
}
