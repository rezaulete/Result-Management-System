/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.school;

import org.springframework.data.jpa.repository.JpaRepository;

import school.model.school.HomeSlider;

/**
 *
 * @author User
 */
public interface HomeSliderRepository extends JpaRepository<HomeSlider, Long> {
    
	public	HomeSlider findById(Long id);

	public HomeSlider findFirstByOrderById();
}
