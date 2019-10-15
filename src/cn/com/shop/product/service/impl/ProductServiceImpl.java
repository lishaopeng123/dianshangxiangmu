package cn.com.shop.product.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.shop.product.mapper.ProductMapper;
import cn.com.shop.product.pojo.Product;
import cn.com.shop.product.service.ProductService;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductMapper productMapper;

	@Override//查询热门商品
	public List<Product> findHotProduct() {
		
		List<Product> plist = productMapper.findHotProduct();
		return plist;
	}

	@Override//查询最新商品
	public List<Product> findNewProduct() {
		
		
		return productMapper.findNewProduct();
	}

	@Override//根据pid查询商品
	public Product findProductBypid(Integer pid) {
		
		Product p = productMapper.selectByPrimaryKey(pid);
		return p;
	}

	@Override
	public PageInfo<Product> findPageHelper(Integer cid, Integer pageNum) {
		
		PageHelper.startPage(pageNum, 12);
		
		List<Product> plist = productMapper.findProductByCid(cid);
		
		//封装pageInfo
		PageInfo<Product> pageInfo = new PageInfo<>(plist);
		
		return pageInfo;
	}



	/*@Override//根据cid查询所有商品
	public List<Product> findProductByCid(Integer cid) {
		
		List<Product> plist = productMapper.findProductByCid(cid);
		return plist;
	}*/
	
}
