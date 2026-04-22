package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.TinTuc;
import repositories.TinTucRepository;

import java.util.List;

@Service
public class TinTucService {

    @Autowired
    private TinTucRepository tinTucRepository;

    // Hàm này sẽ gom toàn bộ tin tức có trong database trả về
    public List<TinTuc> layTatCaTinTuc() {
        return tinTucRepository.findAll();
    }
}
