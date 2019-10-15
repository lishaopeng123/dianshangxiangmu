package cn.com.shop.product.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;

import cn.com.shop.product.pojo.Product;

public interface ProductService {

	List<Product> findHotProduct();//查询热门商品

	List<Product> findNewProduct();//查询最新商品

	Product findProductBypid(Integer pid);//根据pid查询商品

	PageInfo<Product> findPageHelper(Integer cid, Integer pageNum);//根据cid查询所有商品


//	List<Product> findProductByCid(Integer cid);//根据cid查询所有商品


}
