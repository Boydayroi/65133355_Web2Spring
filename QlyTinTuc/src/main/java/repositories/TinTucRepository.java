package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.TinTuc;

public interface TinTucRepository extends JpaRepository<TinTuc, Integer> {

}
