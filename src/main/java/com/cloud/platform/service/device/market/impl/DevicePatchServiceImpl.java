package com.cloud.platform.service.device.market.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.entity.device.market.DevicePatch;
import com.cloud.platform.mapper.device.market.DevicePatchMapper;
import com.cloud.platform.req.DevicePatchREQ;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import com.cloud.platform.service.device.market.IDevicePatchService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统补丁信息表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Service
public class DevicePatchServiceImpl
        extends ServiceImpl<DevicePatchMapper, DevicePatch> implements IDevicePatchService {

  @Resource
  private  DevicePatchMapper patchMapper;
  @Resource
  private IDeviceLinkFileService fileService;
  @Resource
  private IDeviceLinkFileSignService signService;
  @Override
  public ResultVo search(DevicePatchREQ req) {
    QueryWrapper wrapper =new QueryWrapper();
    if (!ObjectUtils.isEmpty(req.getSysName())){
      wrapper.like("dp_sysName",req.getSysName().trim());
    }
    if (!ObjectUtils.isEmpty(req.getSysType())){
      wrapper.like("dp_sysType",req.getSysType().trim());
    }
    if (!ObjectUtils.isEmpty(req.getName())){
      wrapper.like("dp_name",req.getName().trim());
    }
    if (!ObjectUtils.isEmpty(req.getType())){
      wrapper.eq("dp_paType",req.getType());
    }
    if (!ObjectUtils.isEmpty(req.getVersions())){
      wrapper.like("dp_versions",req.getVersions().trim());
    }
    if (!ObjectUtils.isEmpty(req.getPutUnit())){
      wrapper.like("dp_putUnit",req.getPutUnit().trim());
    }
    wrapper.orderByDesc("dp_createTime");
    IPage<DevicePatch> cfgLogs = baseMapper.selectPage(req.getPage(), wrapper);
    return ResultVo.ok(cfgLogs.getRecords(),cfgLogs.getTotal());
  }

  @Override
  public Result delPath(DevicePatchREQ req) {
    baseMapper.deleteById(req.getPaId());
    return Result.ok();
  }

  @Override
  public Result editPath(DevicePatch patch) {
    //更新数字验签文件
    if (!StringUtils.isEmpty(patch.getSignFileId())){
      DeviceLinkFile file = fileService.getById(patch.getPatchFileId());
      file.setFsId(patch.getSignFileId());
      fileService.updateById(file);
    }
    patch.setExamTime(new Date());
    baseMapper.updateById(patch);
    return Result.ok();
  }

  @Override
  public Result savePath(DevicePatch patch) {
    if (!StringUtils.isEmpty(patch.getSignFileId())){
      DeviceLinkFile file = fileService.getById(patch.getPatchFileId());
      file.setFsId(patch.getSignFileId());
      fileService.updateById(file);
    }
    patch.setCreateTime(new Date());
    patch.setState(0);
    baseMapper.insert(patch);
    return Result.ok();
  }

  @Override
  public Result editState(DevicePatchREQ req) {

    Integer integer = patchMapper.editState(req.getPaState(), req.getPaId());

    return  Result.ok();
  }

  @Override
  public List<DevicePatch> getALl() {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.orderByDesc("dp_createTime");
    List<DevicePatch> list = baseMapper.selectList(wrapper);
    return list;
  }


  @Override
  public Result getPatch(String paId) {
    DevicePatch Patch = baseMapper.selectById(paId);
    String patchFileId = Patch.getPatchFileId();
    if (!StringUtils.isEmpty(patchFileId)){
      DeviceLinkFile file = fileService.getById(patchFileId);
      DeviceLinkFileSign sign = signService.getById(file.getFsId());
      Patch.setSignFileId(sign.getDlsId());
      Patch.setSignName(sign.getName());
    }
    return Result.ok(Patch);
  }
}
