package com.itheima.pinyougou.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

public interface BrandService {
	public List<TbBrand> findAll();
	
	public PageResult findByPage(int pageNum,int pageSize);
}
