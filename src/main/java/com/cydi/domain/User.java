package com.cydi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cyd
 * @Package com.cydi.domain
 * @date 2020/6/1 12:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    private Integer id;

    private String username;

    private String loginname;

    private String pwd;

    private String sex;
}
