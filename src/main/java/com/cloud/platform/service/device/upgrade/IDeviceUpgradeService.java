package com.cloud.platform.service.device.upgrade;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
import com.cloud.platform.req.DeviceUpgradeREQ;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.geom.RectangularShape;
import java.util.Map;

/**
 * <p>
 * 设备主信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceUpgradeService extends IService<DeviceUpgrade> {


   Boolean updateUpgrade(String deviceId,Map map);
   DeviceUpgrade  selectByJobId(String jobId);
   Result  getJObid();
   ResultVo upgradeLog(DeviceUpgradeREQ req);
   Result againExce(String duId);
   Result exceUpgrade(DeviceUpgradeREQ req);
   Result statusQuery(Integer jobId,String deviceId);
   Result progress(Integer jobId);

}
