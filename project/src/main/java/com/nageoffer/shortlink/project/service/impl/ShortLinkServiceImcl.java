package com.nageoffer.shortlink.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dao.mapper.LinkMapper;
import com.nageoffer.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.nageoffer.shortlink.project.service.ShortLinkService;
import com.nageoffer.shortlink.project.toolkit.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 短链接接口实现层
 */
@Slf4j
@Service
public class ShortLinkServiceImcl extends ServiceImpl<LinkMapper, ShortLinkDO> implements ShortLinkService {


    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestparam) {
        String shortLinkSuffix = generateSuffix(requestparam);
        ShortLinkDO shortLinkDO = BeanUtil.toBean(requestparam, ShortLinkDO.class);
        shortLinkDO.setFullShortUrl(requestparam.getDomain() + "/" + shortLinkSuffix);
        baseMapper.insert(shortLinkDO);
        return ShortLinkCreateRespDTO.builder()
                .fullShortUrl(shortLinkDO.getFullShortUrl())
                .originUrl(requestparam.getGid())
                .build();
    }

    private String generateSuffix(ShortLinkCreateReqDTO requestparam) {
        String originUrl = requestparam.getOriginUrl();
        return HashUtil.hashToBase62(originUrl);
    }
}
