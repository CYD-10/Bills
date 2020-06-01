package com.cydi.vo;

import com.cydi.domain.Bills;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author cyd
 * @Package com.cydi.VO
 * @date 2020/6/1 17:45
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BillVO extends Bills {
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private Integer page=1;
    private Integer limit=10;
}
