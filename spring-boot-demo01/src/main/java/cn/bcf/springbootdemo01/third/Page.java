package cn.bcf.springbootdemo01.third;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/14 11:04 上午
 */
public class Page {

    private Integer pageNum;
    private Integer pageSize;

    public Page() {
    }

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
