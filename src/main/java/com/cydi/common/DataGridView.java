package com.cydi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyd
 * @Package com.cydi.common
 * @date 2020/6/1 17:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {
    private Long code=0L;
    private String msg="";
    private Long count;
    private Object data;
    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
}
