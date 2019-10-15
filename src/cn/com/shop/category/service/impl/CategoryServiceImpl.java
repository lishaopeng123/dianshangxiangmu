package cn.com.shop.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shop.category.mapper.CategoryMapper;
import cn.com.shop.category.pojo.Category;
import cn.com.shop.category.pojo.CategoryExample;
import cn.com.shop.category.service.CategoryService;
import cn.com.shop.product.mapper.ProductMapper;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override//查询一级导航
	public List<Category> findCategory() {
		CategoryExample example = new CategoryExample();
		return categoryMapper.selectByExample(example);
	}

	@Override
	public List<Category> findCategoryAndCategorysecond() {
		//TODO Auto-generated method stub
		return categoryMapper.findCategoryAndCategorysecond();
	}

	/*@Override//查询一级导航关联查询二级导航
	public List<Category> findCategoryAndCategorysecond() {
		
		
		return categoryMapper.findCategoryAndCategorysecond();
	}*/
	
}
