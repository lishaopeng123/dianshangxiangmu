package cn.com.shop.product.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.shop.product.pojo.Product;
import cn.com.shop.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	//根据pid查询商品
	@RequestMapping("/findProductBypid")
	public String findProductBypid(Integer pid,HttpServletRequest request){
		
		Product p = productService.findProductBypid(pid);
		
		
		request.setAttribute("p", p);
		return "product";
	}
	
	
	
	// 根据cid查询商品
	/*@RequestMapping("/findProductByCid")
	public String findProductByCid(@RequestParam(required=true,defaultValue="1")Integer pageNum, Integer cid,Model model,HttpServletRequest request){
		
		PageHelper.startPage(pageNum, 12);
		
		List<Product> plist = productService.findProductByCid(cid);
		
		//封装pageinfo
		PageInfo<Product> page = new PageInfo<>(plist);
		
		
		//model.addAttribute("plist", plist);
		request.setAttribute("plist", plist);
		request.setAttribute("page", page);
		request.setAttribute("cid", cid);
		
		return "plist";
	}*/
	
	
	
	@RequestMapping("/findProductByCid")
	public String findProductByCid(@RequestParam(required=true,defaultValue="1")Integer pageNum, Integer cid,HttpServletRequest request){
		
		
		
		PageInfo<Product> page = productService.findPageHelper(cid, pageNum);
		
		
		request.setAttribute("page", page);
		request.setAttribute("cid", cid);
		
		return "plist";
	}
	
	
	
	

}
