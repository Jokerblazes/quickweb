package com.joker.quickweb.utils;

import com.github.pagehelper.Page;

public class PageDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNum=1;
	private int pageSize=10;
	private int startRow;
	private int endRow;
	private long total;
	private int pages;

	public PageDto() {
	}

	public PageDto(Page<?> page) {
		this.pageNum = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.startRow = page.getStartRow();
		this.endRow = page.getEndRow();
		this.total = page.getTotal();
		this.pages = page.getPages();
	}
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pagetest [pageNum=" + pageNum + ", pageSize=" + pageSize + ", startRow=" + startRow + ", endRow="
				+ endRow + ", total=" + total + ", pages=" + pages + "]";
	}
}
