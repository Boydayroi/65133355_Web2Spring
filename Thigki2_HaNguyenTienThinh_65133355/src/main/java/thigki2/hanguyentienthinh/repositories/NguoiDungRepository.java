package thigki2.hanguyentienthinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thigki2.hanguyentienthinh.models.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
   
    NguoiDung findByUsernameAndPassword(String username, String password);
}
