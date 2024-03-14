package com.horseko.infra.basic.service.impl;

import com.horseko.infra.basic.entity.SubjectLabel;
import com.horseko.infra.basic.mapper.SubjectLabelDao;
import com.horseko.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-13 09:23:13
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param subjectLabel 主键
     * @return 实例对象
     */
    @Override
    public List<SubjectLabel> queryLabelByCategoryId(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.queryLabelByCategoryId(subjectLabel);
    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int add(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.insert(subjectLabel);
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectLabel subjectLabel) {
        int count = this.subjectLabelDao.update(subjectLabel);
        return count;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectLabel> batchQueryById(List<Long> labelIds) {
        return this.subjectLabelDao.batchQueryById(labelIds);
    }
}
