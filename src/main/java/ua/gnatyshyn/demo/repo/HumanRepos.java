package ua.gnatyshyn.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.gnatyshyn.demo.Entity.Human;
@Repository
public interface HumanRepos extends JpaRepository<Human, Long> {
}
