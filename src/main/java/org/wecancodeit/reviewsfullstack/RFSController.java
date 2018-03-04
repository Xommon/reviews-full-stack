package org.wecancodeit.reviewsfullstack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RFSController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping(value = "categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categoriesModel", categoryRepo.findAll());
		return "categoriesView";
	}

	// @RequestMapping(value = "reviews")
	// public String getAReview(Model model) {
	// model.addAttribute("reviews", reviewRepo.findAll());
	// return "reviews";
	// }

	@RequestMapping(value = "reviewbycategory")
	public String getACategory(@RequestParam Long id, Model model) {
		model.addAttribute("reviewByCategoryModel", reviewRepo.findAllByCategory(categoryRepo.findOne(id)));
		return "reviewByCategoryView";
	}

	// @RequestMapping(value = "category")
	// public String getListofCategories(@RequestParam Long id, Model model) {
	// model.addAttribute("singleCategoryModel", categoryRepo.findOne(id));
	// return "singleCategoryView";
	// }

	@RequestMapping(value = "review")
	public String getSingleReview(@RequestParam Long id, Model model) {
		model.addAttribute("reviewModel", reviewRepo.findOne(id));
		return "reviewView";
	}

}
