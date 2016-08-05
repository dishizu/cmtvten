package com.example.administrator.chushoutv.utils;

/**
 *格式化Html文件的工具类
 */
public class FormattedHtml {

    /**格式化html字符串
     * @param htmlString ------>html字符串
     * @return String ----------->格式化后的字符串
     * */
    public static String formative(String htmlString){

        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        localStringBuilder.append("<html><head>");
        localStringBuilder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        localStringBuilder.append("<style type=\"text/css\">");
        localStringBuilder.append("<!--body{margin:10px 15px 15px 15px;font-size:18px;font-family:\"宋体\"} body p{line-height:28px;}");
        localStringBuilder.append(" img{margin-left:15;margin-right:0;width:100%;text-indent:-2em;}");
        localStringBuilder.append("--></style></head><body>");
        localStringBuilder.append(htmlString);
        localStringBuilder.append("</body></html>");
        return localStringBuilder.toString();
    }

}
