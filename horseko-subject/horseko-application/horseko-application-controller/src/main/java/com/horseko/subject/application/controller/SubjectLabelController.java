package com.horseko.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.horseko.domain.entity.SubjectLabelBO;
import com.horseko.domain.service.SubjectLabelDomainService;
import com.horseko.infra.basic.entity.SubjectLabel;
import com.horseko.infra.basic.service.SubjectLabelService;

import com.horseko.subject.application.convert.SubjectLabelDTOConverter;
import com.horseko.subject.application.dto.SubjectLabelDTO;
import com.horseko.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 题目标签表(SubjectLabel)表控制层
 *
 * @author makejava
 * @since 2024-03-13 09:23:09
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SubjectLabel> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.subjectLabelDomainService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param subjectLabelDTO
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()),"标签名称不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.dto:{}", e.getMessage(), e);
        }
        return Result.fail("新增标签失败");

    }

    /**
     * 编辑数据
     *
     * @param subjectLabel 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SubjectLabel> edit(SubjectLabel subjectLabel) {
        return ResponseEntity.ok(this.subjectLabelDomainService.update(subjectLabel));
    }

}

