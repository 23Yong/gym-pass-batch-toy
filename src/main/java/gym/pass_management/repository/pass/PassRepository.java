package gym.pass_management.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {
}
