package com.vpclub.result;



public class BasePageParam {

    protected Integer pageSize;
    protected Integer pageNumber;

    public BasePageParam(){}


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    protected Integer  startRow;


    public BasePageParam(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.startRow = (null != pageNumber && 0 != pageNumber ? pageNumber - 1 : 0) * (null == pageSize ? 10 : pageSize);
    }

    public Integer getStartRow() {
        return this.startRow = (null != this.getPageNumber() && 0 != this.getPageNumber() ? this.getPageNumber() - 1 : 0) * (null == this.getPageSize() ? 10 : this.getPageSize());
    }

}
