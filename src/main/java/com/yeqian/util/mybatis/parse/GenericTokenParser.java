package com.yeqian.util.mybatis.parse;

import java.util.List;

public class GenericTokenParser {

    private String openToken; //开始标记
    private String closeToken; //结束标记
    private TokenHandler tokenHandler;//标记处理器

    public GenericTokenParser(String openToken, String closeToken, TokenHandler tokenHandler) {
        this.openToken = openToken;
        this.closeToken = closeToken;
        this.tokenHandler = tokenHandler;
    }

    public String parse(String text) {
        // select * from tb_user where id = #{id} and name = #{name}
        StringBuilder result = new StringBuilder();
        char[] textChar = text.toCharArray();
        int offset = 0;
        int start = text.indexOf(this.openToken);
        while (start > -1) {
            //存在开始标记
            int end = text.indexOf(this.closeToken, start);
            if (end > -1) {
                //存在结束标记
                result.append(textChar, offset, start - offset);
                offset = start + this.openToken.length();
                String paramName = new String(textChar, offset, end - offset);
                //调用相关tokenHandler处理器，并传入每次解析出来的参数名放到parameterMappings中
                result.append(tokenHandler.handleToken(paramName));
                offset = end + this.closeToken.length();
            } else {
                //不存在结束标记
                result.append(textChar, offset, text.length() - offset);
                offset = text.length();
            }
            start = text.indexOf(this.openToken, offset);
        }

        //如果标记点位置小于内容长度，将result补齐
        if (offset < text.length()) {
            result.append(textChar, offset, text.length() - offset);
        }
        return result.toString();
    }

    //测试解析sql
    public static void main(String[] args) {
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String sql = genericTokenParser.parse("select * from tb_user where id = #{id} and name = #{name}");
        List<String> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        System.out.println(parameterMappings);
        System.out.println(sql);
    }
}
