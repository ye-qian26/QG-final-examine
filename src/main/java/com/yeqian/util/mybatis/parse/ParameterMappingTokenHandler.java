package com.yeqian.util.mybatis.parse;

import java.util.ArrayList;
import java.util.List;

/**
 * 所需参数集合处理器
 */
public class ParameterMappingTokenHandler implements TokenHandler {
    private List<String> parameterMappings = new ArrayList<String>();

    public List<String> getParameterMappings() {
        return parameterMappings;
    }

    @Override
    public String handleToken(String content) {
        parameterMappings.add(content);
        return "?";
    }
}
