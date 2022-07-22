package com.offcn.bean;


public class Page {
    //设置当前的页码
    private  Integer pageNum = 1 ;
    //设置数据索引值
    private  Integer pageIndex = 0 ;
    //设置每页显示的数据条数
    private  Integer pageSize = 2 ;
    //设置总页码
    private  Integer totalPage  ;
    //设置总记录条数
    private  Integer totalCount ;
    //获取索引     (pageNum-1) * pageSize
    //(当前页-1)  * 每层页数
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    //获取查询索引   (pageNum-1) * pageSize  （当前页-1）*每页条数
    public Integer getPageIndex() {
        return (pageNum-1) * pageSize;
    }

    //设置总条数  同时设置总页码     总页码=（总条数+每页条数-1）/每页条数
    //总共11条数据，每页显示5条数据，总共页码？3
    //每页显示5条数据,总共3页 数据有多少条？11~15  15~19/5=->3   如何把11~15->15~19 +4(5-1)
    //                                 总条数 +（5-1）/ 5   =  总页码
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        this.totalPage = (this.totalCount + pageSize - 1) / pageSize;
    }


    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalPag=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }
}
