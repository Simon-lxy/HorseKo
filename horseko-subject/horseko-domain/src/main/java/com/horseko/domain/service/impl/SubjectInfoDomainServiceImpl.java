package com.horseko.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.horseko.domain.convert.SubjectInfoConverter;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.domain.handler.subject.SubjectTypeHandler;
import com.horseko.domain.handler.subject.SubjectTypeHandlerFactory;
import com.horseko.domain.service.SubjectInfoDomainService;
import com.horseko.infra.basic.entity.SubjectCategory;
import com.horseko.infra.basic.entity.SubjectInfo;
import com.horseko.infra.basic.entity.SubjectMapping;
import com.horseko.infra.basic.mapper.SubjectInfoDao;
import com.horseko.infra.basic.service.SubjectInfoService;
import com.horseko.infra.basic.service.SubjectMappingService;
import com.horseko.subject.common.enums.IsDeletedFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-03-13 18:34:40
 */
@Service("subjectInfoDomainService")
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {
    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoService.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectInfoBO 实例对象
     * @return 实例对象
     */
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainService.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        //假设我们都写在主流程里
        //判断type 单选的调用单选的service  多选调用多选的
        //一大堆的if
        //因此   用  工厂+策略 的形式
        //一个工厂包含4中类型   根据传入的type自动映射选择处理
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
        handler.add(subjectInfoBO);
        //_______________________________________________________________________________
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);
    }

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo update(SubjectInfo subjectInfo) {
        this.subjectInfoService.update(subjectInfo);
        return this.queryById(subjectInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
//        return this.subjectInfoService.deleteById(id) > 0;
        return false;
    }
}
