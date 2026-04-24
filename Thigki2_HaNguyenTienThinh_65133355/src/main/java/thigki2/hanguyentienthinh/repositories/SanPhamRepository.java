package thigki2.hanguyentienthinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thigki2.hanguyentienthinh.models.SanPham;
import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
  
    List<SanPham> findByTheLoaiId(int theLoaiId);
}