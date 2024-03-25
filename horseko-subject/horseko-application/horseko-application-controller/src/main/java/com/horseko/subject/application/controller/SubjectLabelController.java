package com.horseko.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.horseko.auth.domain.entity.SubjectLabelBO;
import com.horseko.auth.domain.service.SubjectLabelDomainService;

import com.horseko.subject.application.convert.SubjectLabelDTOConverter;
import com.horseko.subject.application.dto.SubjectLabelDTO;
import com.horseko.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
     * 通过分类ID查询标签
     *
     * @param subjectLabelDTO
     * @return
     */
    @GetMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelBO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类ID不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBO(subjectLabelDTO);
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            return Result.ok(subjectLabelBOList);
        } catch (Exception e) {
            log.error("SubjectLabelController.queryLabelByCategoryId.dto:{}", e.getMessage(), e);
            return Result.fail("查询标签失败");
        }
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
     * 修改数据
     *
     * @param subjectLabelDTO 实体
     * @return 修改结果
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签ID不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.update.dto:{}", e.getMessage(), e);
            return Result.fail("修改标签失败");
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签ID不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.update.dto:{}", e.getMessage(), e);
            return Result.fail("修改标签失败");
        }
    }
}

