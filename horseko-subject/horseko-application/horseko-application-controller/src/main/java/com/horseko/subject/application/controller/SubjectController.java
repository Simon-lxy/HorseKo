package com.horseko.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.domain.service.SubjectInfoDomainService;
import com.horseko.infra.basic.entity.SubjectInfo;
import com.horseko.infra.basic.service.SubjectInfoService;
import com.horseko.subject.application.convert.SubjectAnswerConverter;
import com.horseko.subject.application.convert.SubjectInfoConverter;
import com.horseko.subject.application.dto.SubjectInfoDTO;
import com.horseko.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表控制层
 *
 * @author makejava
 * @since 2024-03-13 18:34:40
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SubjectInfo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.subjectInfoDomainService.queryById(id));
    }

    /**
     * 新增题目
     *
     * @param subjectInfoDTO 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds())
                    , "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds())
                    , "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoConverter.INSTANCE.convertDtoTOBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = SubjectAnswerConverter.INSTANCE.convertListDtoTOBo(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectInfoController.add.dto:{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }

    }

    /**
     * 编辑数据
     *
     * @param subjectInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SubjectInfo> edit(SubjectInfo subjectInfo) {
        return ResponseEntity.ok(this.subjectInfoDomainService.update(subjectInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.subjectInfoDomainService.deleteById(id));
    }

}

