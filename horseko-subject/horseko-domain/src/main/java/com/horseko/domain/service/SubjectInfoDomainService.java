package com.horseko.domain.service;

import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectInfo;


/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-03-13 18:34:40
 */
public interface SubjectInfoDomainService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectInfoBO 实例对象
     * @return 实例对象
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
