package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.LoaiTin;
import models.TinTuc;

public interface LoaiTinRepository extends JpaRepository<LoaiTin, Integer> {

}
