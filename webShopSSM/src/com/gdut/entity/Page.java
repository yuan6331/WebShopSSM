package com.gdut.entity;

public class Page {
	private int pageIndex;   //��ǰҳ
	private int currentPage; //��ǰҳ
	private int prePage;	 //��һҳ
	private int nextPage;	 //��һҳ
	private int pageSize;	 //ÿҳ��¼��
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	private int totalPage;	 //��ҳ��
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Page(int pageIndex,int currentPage, int prePage, int nextPage, int pageSize, int totalPage) {
		super();
		this.pageIndex = pageIndex;
		this.currentPage = currentPage;
		this.prePage = prePage;
		this.nextPage = nextPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}
	
	
}
