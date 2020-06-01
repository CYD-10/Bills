package com.cydi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyd
 * @Package com.cydi.common
 * @date 2020/6/1 11:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
    //业务响应码
    private int code;
    //业务响应消息
    private String msg;
}
