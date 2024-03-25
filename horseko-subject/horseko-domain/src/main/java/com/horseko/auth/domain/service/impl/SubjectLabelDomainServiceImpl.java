package com.horseko.auth.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.horseko.auth.domain.convert.SubjectLabelConverter;
import com.horseko.auth.domain.entity.SubjectLabelBO;
import com.horseko.auth.domain.service.SubjectLabelDomainService;
import com.horseko.infra.basic.entity.SubjectLabel;
import com.horseko.infra.basic.service.SubjectLabelService;
import com.horseko.subject.common.enums.IsDeletedFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
     * @param subjectLabelBO
     * @return 实例对象
     */
    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.queryLabelByCategoryId.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoTOLabel(subjectLabelBO);
        List<SubjectLabel> subjectLabels = subjectLabelService.queryLabelByCategoryId(subjectLabel);
        List<SubjectLabelBO> subjectLabelBOS = SubjectLabelConverter.INSTANCE.convertLabelListTOLabelBOList(subjectLabels);
        return subjectLabelBOS;
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
            log.info("SubjectLabelDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoTOLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count = subjectLabelService.add(subjectLabel);
        return count > 0;
    }

    /**
     * 修改数据
     *
     * @param subjectLabelBO 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoTOLabel(subjectLabelBO);
        int count = this.subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 删除数据
     *
     * @param subjectLabelBO 实例对象
     * @return
     */
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoTOLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

}
