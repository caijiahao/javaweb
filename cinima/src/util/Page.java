package util;

public class Page {
    //
    private Integer start;
    private Integer limit;
    private String sort;
    private String dir;

    //
    private Object result;
    private Long totalCount;

    //
    public Page() {
    }

    public Page(Object result, Long totalCount) {
        this.result = result;
        this.totalCount = totalCount;
    }

    public Page(int start, int limit, String sort, String dir) {
        this.start = start;
        this.limit = limit;
        this.sort = sort;
        this.dir = dir;
    }

    //
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public boolean isAsc() {
        return !"DESC".equalsIgnoreCase(dir);
    }

    //
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}

