package com.zzm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-08-12
 * @time 17:25
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
@Data
public class CompanyDto implements Serializable {

    private static final long serialVersionUID = 6950470307882802135L;

    private Long id;

    private String companyName;

    private String companyContent;

    private CompanyDto superior;
}
