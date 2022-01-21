package com.cloud.platform.service.device.market;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.market.DevicePatch;
import com.cloud.platform.req.DevicePatchREQ;

import java.util.List;

/**
 * <p>
 * 系统补丁信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
public interface IDevicePatchService extends IService<DevicePatch> {

  ResultVo search(DevicePatchREQ req);
  Result delPath(DevicePatchREQ req);
  Result editPath(DevicePatch patch);
  Result savePath(DevicePatch patch);
  Result editState(DevicePatchREQ req);
  List<DevicePatch> getALl();
}
