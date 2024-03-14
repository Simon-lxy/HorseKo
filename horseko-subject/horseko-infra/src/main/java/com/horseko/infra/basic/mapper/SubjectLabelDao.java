package com.horseko.infra.basic.mapper;

import com.horseko.infra.basic.entity.SubjectLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 题目标签表(SubjectLabel)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-13 09:23:11
 */
public interface SubjectLabelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<SubjectLabel> queryLabelByCategoryId(SubjectLabel subjectLabel);


    /**
     * 统计总行数
     *
     * @param subjectLabel 查询条件
     * @return 总行数
     */
    long count(SubjectLabel subjectLabel);

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 影响行数
     */
    int insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 影响行数
     */
    int update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<SubjectLabel> batchQueryById(@Param("list") List<Long> labelIds);
}

