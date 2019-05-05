package com.itheima.pinyougou.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

public interface BrandService {
	public List<TbBrand> findAll();
	
	public PageResult findByPage(TbBrand brand,int pageNum,int pageSize);
	
	public void save(TbBrand brand);
	
	public TbBrand findOne(Long id);
	
	public void update(TbBrand tbBrand);
	
	public void delete(Long[] ids);
}
