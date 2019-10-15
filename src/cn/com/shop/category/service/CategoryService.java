package cn.com.shop.category.service;

import java.util.List;

import cn.com.shop.category.pojo.Category;

public interface CategoryService {

	List<Category> findCategory();//查询一级导航

	List<Category> findCategoryAndCategorysecond();//查询一级导航关联查询二级导航

	//List<Category> findCategoryAndCategorysecond();//查询一级导航关联查询二级导航


}
