package thigk2.hanguyentienthinh.models;
import jakarta.persistence.*;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenTheLoai;

    