package com.hang.people_management.util;

public class Condition {
    // 后端的查询语句只能接收一个参数，故需要把前端发送的多个请求参数包装到一个类中，向后端传递
    // 无需被Spring管理
    private int currentPage;
    private int pageSize;

    public Condition() {
    }

    public Condition(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
