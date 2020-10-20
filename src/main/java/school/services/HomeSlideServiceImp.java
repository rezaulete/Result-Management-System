package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.model.school.HomeSlider;
import school.repository.school.HomeSliderRepository;

@Service
public class HomeSlideServiceImp implements HomeSlideService {

	@Autowired
	HomeSliderRepository homeSliderRepository;
	
	@Override
	public List<HomeSlider> findAll() {
		List<HomeSlider> homeSlider=(List<HomeSlider>) homeSliderRepository.findAll();
		return homeSlider;
	}

	@Override
	public HomeSlider getHomeSliderByID(Long id) {
		HomeSlider homeSlider= (HomeSlider) homeSliderRepository.findById(id);
		return homeSlider;
	}

	@Override
	public HomeSlider getSingleHomeSlider() {
		HomeSlider homeSlider= (HomeSlider) homeSliderRepository.findFirstByOrderById();
		return homeSlider;
	}

}
