package com.zzm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-07-22
 * @time 19:42
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
@Data
public class Blog implements Serializable {

    private static final long serialVersionUID = -7459907987773774588L;
    private Long id;

    private String title;

    private String content;

    private UserTest userTest;


}
