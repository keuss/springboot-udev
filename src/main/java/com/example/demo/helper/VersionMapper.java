package com.example.demo.helper;

import com.example.demo.pojo.Version;
import com.example.demo.pojo.VersionJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VersionMapper {

    public Version mapTo(VersionJSON versionJSON) {
        Assert.notNull(versionJSON, "The versionJSON must not be null");
        Version v = new Version();
        // must not set id !
        v.setDate(versionJSON.getDate());
        v.setDescription(versionJSON.getDescription());
        return v;
    }

    public VersionJSON mapTo(Version version) {
        Assert.notNull(version, "The version must not be null");
        VersionJSON versionJSON = new VersionJSON();
        versionJSON.setDate(version.getDate());
        versionJSON.setDescription(version.getDescription());
        versionJSON.setId(version.getId());
        return versionJSON;
    }

    public List<VersionJSON> mapTo(List<Version> versionList) {
        if (versionList != null) {
            return versionList.stream().map(this::mapTo).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
