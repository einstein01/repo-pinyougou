package entity;
/**
 * 分页结果实体类
 * */

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
	//总记录数
	private Long total;   
	//每页的数据
	private List rowsList;
	
	public PageResult() {
		super();
	}
	
	
	public PageResult(Long total, List rowsList) {
		super();
		this.total = total;
		this.rowsList = rowsList;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRowsList() {
		return rowsList;
	}
	public void setRowsList(List rowsList) {
		this.rowsList = rowsList;
	}

	
}
