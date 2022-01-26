package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import com.cloud.platform.mapper.device.DeviceLinkLinksMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.service.device.IDeviceLinkLinksService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 外接设备信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkLinksServiceImpl extends ServiceImpl<DeviceLinkLinksMapper, DeviceLinkLinks>
        implements IDeviceLinkLinksService {

  @Override
  public Boolean saveLinkLinks(Map map) {
    if (!ObjectUtils.isEmpty(map.get("links"))) {
      List<DeviceLinkLinks> linkLinks = createLinkLinks(map);
      baseMapper.insertArrayLinks(linkLinks);
    }
    return true;
  }

  public List<DeviceLinkLinks> createLinkLinks(Map map){
    List<DeviceLinkLinks> list =new ArrayList<>();
    Object links = map.get("links");
    JSONArray objects = JSONArray.parseArray(links.toString());
    for(int i = 0; i < objects.size(); i++) {
      JSONObject obj = objects.getJSONObject(i);
      DeviceLinkLinks linkLinks =new DeviceLinkLinks();
      linkLinks.setDllDliId(map.get("dliId").toString());
      linkLinks.setDllType(ObjectUtils.isEmpty(obj.get("type"))?null:obj.get("type").toString());
      linkLinks.setDllName(ObjectUtils.isEmpty(obj.get("name"))?null:obj.get("name").toString());
      linkLinks.setDllMac(ObjectUtils.isEmpty(obj.get("mac"))?null:obj.get("mac").toString());
      list.add(linkLinks);
    }
     return list;
  }


  @Override
  public ResultVo getList(DeviceLinkDevREQ req) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("dll_dli_id",req.getDevId());
    wrapper.orderByDesc("dll_createTime");
    IPage<DeviceLinkLinks> page=new Page<DeviceLinkLinks>();
    IPage<DeviceLinkDev> page1 = req.getPage();
    page.setCurrent(page1.getCurrent());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceLinkLinks> linksIPage = baseMapper.selectPage(page, wrapper);
    return ResultVo.ok(linksIPage.getRecords(),linksIPage.getTotal());
  }
}
