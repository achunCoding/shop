package top.wycfight.shop.demo.dto;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 分页数据封装类
 * @create: 2019-04-13 20:32
 * @modify By:
 **/
public class CommonPage<T> {
    /**
     * 分页：当前页
     */
    private Integer pageNum;
    /**
     * 分页：每页多少条
     */
    private Integer pageSize;
    /**
     * 分页：总页数
     */
    private Long totalPage;
    /**
     * 分页：数据
     */
    private List<T> list;

    /**
     * 将PageHelper分页的数据list转为分页信息
     *
     * @param list 数据
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotalPage((pageInfo.getTotal() + pageInfo.getPageSize() - 1 )/ pageInfo.getPageSize());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 获取：当前页
     *
     * @return
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 设置：当前页
     *
     * @param pageNum
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取：每页多少条
     *
     * @return
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置：每页多少条
     *
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取：总页数
     *
     * @return
     */
    public Long getTotalPage() {
        return totalPage;
    }

    /**
     * 设置：总页数
     *
     * @param totalPage
     */
    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取：数据
     *
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置：数据
     *
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }
}
