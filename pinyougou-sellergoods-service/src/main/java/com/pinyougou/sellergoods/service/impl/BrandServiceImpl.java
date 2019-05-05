package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.pinyougou.service.BrandService;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;

import entity.PageResult;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private TbBrandMapper tbBrandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		
		return tbBrandMapper.selectByExample(null);
		
		
		
	}

	@Override
	public PageResult findByPage(TbBrand brand,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample tbBrandExample = new TbBrandExample();
		Criteria criteria = tbBrandExample.createCriteria();
		if(brand!=null) {
			if(brand.getName()!=null && brand.getName().length()>0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0) {
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(tbBrandExample);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void save(TbBrand brand) {
		tbBrandMapper.insert(brand);
	}

	@Override
	public TbBrand findOne(Long id) {
		
		return tbBrandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand tbBrand) {
		tbBrandMapper.updateByPrimaryKey(tbBrand);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
		
	}

}
