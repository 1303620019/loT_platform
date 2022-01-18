package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.entity.device.DeviceLinkMem;
import com.cloud.platform.mapper.device.DeviceLinkFileSignMapper;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 *  数字签证信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkFileSignServiceImpl
        extends ServiceImpl<DeviceLinkFileSignMapper, DeviceLinkFileSign> implements IDeviceLinkFileSignService {

  @Override
  public DeviceLinkFileSign getFileSign(String fsId) {
    DeviceLinkFileSign deviceLinkFileSign = baseMapper.selectById(fsId);
    return deviceLinkFileSign;
  }

  @Override
  public String saveFileSign(Map map) {
    if (!ObjectUtils.isEmpty(map.get("sign"))) {
      Map<String, Object> sign = JSON.parseObject(map.get("sign").toString(), Map.class);
      DeviceLinkFileSign fileSign = createSign(sign);
      int insert = baseMapper.insert(fileSign);
      if (!ObjectUtils.isEmpty(insert)){
          return fileSign.getDlsId();
      }
    }
    return null;
  }



  public  DeviceLinkFileSign createSign(Map map){
    DeviceLinkFileSign sign=new DeviceLinkFileSign();
    sign.setMd5(ObjectUtils.isEmpty(map.get("md5"))?null:map.get("md5").toString());
    sign.setName(ObjectUtils.isEmpty(map.get("name"))?null:map.get("name").toString());
    sign.setUrl(ObjectUtils.isEmpty(map.get("url"))?null:map.get("url").toString());
    sign.setSize(ObjectUtils.isEmpty(map.get("size"))?null:Integer.parseInt(map.get("size").toString()));
    sign.setDlsCreatetime(new Date());
    return sign;
  }
}
