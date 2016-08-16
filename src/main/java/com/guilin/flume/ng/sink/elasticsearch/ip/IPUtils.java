package com.guilin.flume.ng.sink.elasticsearch.ip;

import com.htjc.common.ip.Geography;
import com.htjc.common.ip.IpSearch;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @project aleiye-ip-utils
 * @auth wentao.yu
 * @Date 16/1/21AM10:13
 */
public class IPUtils {

    private static final String path = System.getProperty("user.dir") + "/conf/ip-utf82.dat";

    public static Map<String, Object> parse(String ip) {
        Geography geography = IpSearch.getInstance(path).getToVo(ip);

        if (geography == null) return null;

        Map<String, Object> map = new HashedMap();

        map.put("continent", geography.getContinent());
        map.put("country", geography.getCountry());
        map.put("province", geography.getProvince());
        map.put("city", geography.getCity());
        map.put("operator", geography.getOperator());
        map.put("countryEN", geography.getCountryEN());
        map.put("abbreviation", geography.getAbbreviation());
        map.put("longitude", geography.getLongitude());
        map.put("latitude", geography.getLatitude());

        return map;
    }
}
