package com.zzm.dao;

import com.zzm.entity.Blog;
import com.zzm.entity.CompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-07-22
 * @time 19:32
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
@Mapper
public interface BlogMapper {

    Blog selectBlog(@Param("id") int id);


    CompanyDto selectCompanyDto(@Param("id") Long id);

    String containsKey(@Param("configKey") String configKey);
}
