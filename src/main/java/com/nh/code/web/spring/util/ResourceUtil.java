package com.nh.code.web.spring.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ResourceUtil
 * @Description TODO
 * @Date 2019/8/20 2:23 PM
 * @Created by nihui
 */
public class ResourceUtil {
    public ResourceUtil() {
    }

    public static Resource[] resolveLocationsToResource(String[] locations) {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<Resource> resources = new ArrayList();
        if (locations != null) {
            String[] var3 = locations;
            int var4 = locations.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String location = var3[var5];

                try {
                    Resource[] mappers = resourceResolver.getResources(location);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException var8) {
                    ;
                }
            }
        }

        return (Resource[])resources.toArray(new Resource[resources.size()]);
    }
}
