package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkFile;

import java.util.Map;

/**
 * <p>
 * 文件信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkFileService extends IService<DeviceLinkFile> {


  DeviceLinkFile getFile(String dlfId);

  Boolean   saveFile(Map map);

}
