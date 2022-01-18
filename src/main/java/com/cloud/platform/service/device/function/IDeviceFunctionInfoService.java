package com.cloud.platform.service.device.function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.req.DeviceConfigureREQ;
import com.cloud.platform.req.FunctionREQ;
import org.springframework.web.bind.annotation.RequestBody;

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
}
