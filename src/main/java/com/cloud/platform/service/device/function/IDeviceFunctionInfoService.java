package com.cloud.platform.service.device.function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.req.FunctionREQ;

import java.util.Map;

/**
 * <p>
 * 设备运行状态 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface IDeviceFunctionInfoService extends IService<DeviceFunctionInfo> {
   String saveFunctionInfo(Map map);

   ResultVo search(FunctionREQ req);
   ResultVo cfgSearch(FunctionREQ req);
   Result stateInfo(DeviceLinkDevREQ req);
}
