package com.horseko.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.horseko.domain.convert.SubjectLabelConverter;
import com.horseko.domain.entity.SubjectLabelBO;
import com.horseko.domain.service.SubjectLabelDomainService;
import com.horseko.infra.basic.entity.SubjectLabel;
import com.horseko.infra.basic.mapper.SubjectLabelDao;
import com.horseko.infra.basic.service.SubjectLabelService;
import com.horseko.subject.common.enums.IsDeletedFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-13 09:23:13
 */
@Service("subjectLabelDomainService")
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectLabelBO 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoTOLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count = subjectLabelService.add(subjectLabel);
        return count > 0;
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel update(SubjectLabel subjectLabel) {
        this.subjectLabelService.update(subjectLabel);
        return this.queryById(subjectLabel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
//    @Override
//    public boolean deleteById(Long id) {
//        return this.subjectLabelService.deleteById(id) > 0;
//    }
}
