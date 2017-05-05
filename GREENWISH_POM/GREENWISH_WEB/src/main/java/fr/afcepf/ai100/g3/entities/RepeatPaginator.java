package fr.afcepf.ai100.g3.entities;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai100.g3.CatalogueBean;

public class RepeatPaginator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_RECORDS_NUMBER = 4;
	private static final int DEFAULT_PAGE_INDEX = 1;
	
	private int records;
	private int recordsTotal;
	private int pageIndex;
	private int pages;
	private List<?> origModel;
	private List<?> model;
	
	public RepeatPaginator(List<?> model){
		this.origModel = model;
		this.records = DEFAULT_RECORDS_NUMBER;
		this.pageIndex = DEFAULT_PAGE_INDEX;
		this.recordsTotal = model.size();
		
		if(records > 0){
			pages = records <= 0 ? 1 : recordsTotal / records;
			
			if(recordsTotal % records > 0){
				pages++;
			}
			
			if(pages == 0){
				pages = 1;
			}
		}else{
			records = 1;
			pages = 1;
		}
		
		updateModel();
	}
	
	public void updateModel(){
		int fromIndex = getFirst();
		int toIndex = getFirst() + records;
		
		if(toIndex > this.recordsTotal){
			toIndex = this.recordsTotal;
		}
		this.model = origModel.subList(fromIndex, toIndex);

	}
	
	public void next() {
		if(this.pageIndex < pages) {
			this.pageIndex++;
		}
		
		updateModel();
	}
	public void prev() {
		if(this.pageIndex > 1){
			this.pageIndex--;
		}
		
		updateModel();
	}
	
	public int getFirst() {
		return (pageIndex * records) - records;
	}
	
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<?> getOrigModel() {
		return origModel;
	}
	public void setOrigModel(List<?> origModel) {
		this.origModel = origModel;
	}
	public List<?> getModel() {
		return model;
	}
	public void setModel(List<?> model) {
		this.model = model;
	}
	public static int getDefaultRecordsNumber() {
		return DEFAULT_RECORDS_NUMBER;
	}
	public static int getDefaultPageIndex() {
		return DEFAULT_PAGE_INDEX;
	}
	
	

}
