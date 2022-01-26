package com.cloud.platform.service.device.run.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.run.DeviceBatch;
import com.cloud.platform.entity.device.run.DeviceBatchInfo;
import com.cloud.platform.mapper.device.run.DeviceBatchMapper;
import com.cloud.platform.req.DeviceBatchInfoREQ;
import com.cloud.platform.service.device.run.IDeviceBatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 设备批次 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Service
public class DeviceBatchServiceImpl
        extends ServiceImpl<DeviceBatchMapper, DeviceBatch> implements IDeviceBatchService {
  @Resource
  private DeviceBatchMapper batchMapper;
  @Override
  public ResultVo getBatchInfoByBatchId(DeviceBatchInfoREQ req) {
    IPage<DeviceBatch> page=new Page<DeviceBatch>();
    IPage<DeviceBatchInfo> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceBatch> batchInfoByBatchId = batchMapper.getBatchInfoByBatchId(page, req);
    return ResultVo.ok(batchInfoByBatchId.getRecords(),batchInfoByBatchId.getTotal());
  }
}
