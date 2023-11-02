package cz.project.trixitest.repository;
import cz.project.trixitest.models.CastObce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastObceRepository extends JpaRepository<CastObce, Integer> {
}
