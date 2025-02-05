package kea.momo.jpaonetomany.repository;

import kea.momo.jpaonetomany.model.Kommune;
import kea.momo.jpaonetomany.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
}
