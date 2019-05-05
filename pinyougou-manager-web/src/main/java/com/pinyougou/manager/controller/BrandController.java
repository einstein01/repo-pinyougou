package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pinyougou.service.BrandService;
import com.pinyougou.pojo.TbBrand;

import entity.PageResult;
import entity.Result;
 
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandService brandService; 
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(int page,int size) {
		return brandService.findByPage(null,page, size);
	}
	
	
	@RequestMapping("/save")
	public Result save(@RequestBody TbBrand tbBrand ) {
		try {
			brandService.save(tbBrand);
			return new Result(true,"添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"添加失败");
		}
	}
	
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand ) {
		try {
			brandService.update(tbBrand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
	
	
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int page,int size) {
		return brandService.findByPage(tbBrand,page, size);
	}
}
