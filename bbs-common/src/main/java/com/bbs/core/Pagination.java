package com.bbs.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pagination {

    private static final Logger LOGGER = LoggerFactory.getLogger(Pagination.class);

    public static final Integer DEFAULT_PAGE_LENGTH = 10;

    /**
     * 分页查询开始记录位置
     */
    private int begin = 0;

    /**
     * 分页查看下结束位置
     */
    private int end;

    /**
     * 每页显示记录数
     */
    private int length = DEFAULT_PAGE_LENGTH;

    /**
     * 查询结果总记录数
     */
    private int count;

    /**
     * 当前页码,默认第1页,从1开发算起
     */
    private int current = 1;

    /**
     * 总共页数
     */
    private int total;

    private List dataList;

    private int pageSize = 5;

    public Pagination() {
    }

    public Pagination(int begin) {
        this.begin = begin;
    }

    public Pagination(int begin, int length) {
        this.begin = begin;
        this.length = length;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end = this.begin + this.length;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCount() {
        return count;
    }

    /**
     * *********************** V2.0-bug修复(Roceys)
     * 当分页总页数大于1页，到除首页外的其它页上设置了每页显示条数，且该数大于总数据量时查询结果无数据。 原因:计算出来的当前页分页起止位置超过当总页数
     * 解决:如果当前页大于总页数时回归到首页 ***********************
     * 
     * @Title: setCount
     * @Description: 根据待分页总数据量计算相关参数
     * @param count
     *            总记录数
     * @return void
     * @throws
     * @author yanqing.luo （roceys#gmail.com）
     * @version V2.0
     * @date 2014年10月14日 上午10:55:36
     */
    public void setCount(int count) {
        this.count = count;
        this.begin = (this.current - 1) * this.length;
        this.end = this.begin + this.length;
        this.total = (int) Math.floor((this.count * 1.0d) / this.length);
        if (this.count % this.length != 0) {
            this.total++;
        }

        // bug fixed by roceys.
        if (this.current > this.total)
            setCurrent(1);

        LOGGER.info("count:{}, total:{}, length: {}", this.count, this.total, this.length);
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
        this.begin = (this.current - 1) * this.length;
        this.end = this.begin + this.length;
        LOGGER.debug("current:{}, begin:{}, end: {}", this.current, this.begin, this.end);
    }

    public int getTotal() {
        if (total == 0) {
            return 1;
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFirstPage() {
        return current == 1;
    }

    public boolean isLastPage() {
        return current == total;
    }

    public boolean isShowLastPage() {
        if (total <= pageSize) {
            return false;
        }
        if (current == total) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 功能描述: <br>
     * 页面显示分页的个数
     * 
     * @param pageSize
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Integer> getSkipPageList() {
        int pageSize = this.pageSize;
        List<Integer> result = new ArrayList<Integer>();
        int preC = current - 1;
        int start = 1;
        int end = pageSize;
        if (preC == 0) {
            if (end >= total) {
                end = total;
            }
        } else {

            int tmp = pageSize % 2 == 0 ? pageSize / 2 : pageSize / 2 + 1;
            end = preC + tmp;
            if (end >= total) {
                end = total;
            }
            if (end < pageSize && total >= pageSize) {
                end = pageSize;
            }
            start = end - pageSize + 1;
            if (start < 1) {
                start = 1;
            }

        }

        for (int i = start; i <= end; i++) {
            result.add(i);
        }
        return result;
    }

    public Integer getPrevPage() {
        int tmp = current - 1;
        if (tmp == 0) {
            tmp = 1;
        }
        return tmp;
    }

    public Integer getNextPage() {
        int tmp = current + 1;
        if (tmp > total) {
            tmp = total;
        }
        return tmp;
    }

}