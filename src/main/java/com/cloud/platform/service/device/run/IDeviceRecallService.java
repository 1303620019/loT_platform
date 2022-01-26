package com.cloud.platform.service.device.run;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.run.DeviceRecall;

import java.util.List;

/**
 * <p>
 * 召回类型列表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
public interface IDeviceRecallService extends IService<DeviceRecall> {


 List<DeviceRecall> getList(List<String> recalls);

}
