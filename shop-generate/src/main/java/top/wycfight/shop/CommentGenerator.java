package top.wycfight.shop;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author: wycfight@163.com
 * @description: 自定义注释生成器
 * @create: 2019-04-05 12:01
 * @modify By:
 **/
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;


    /**
     * 设置用户配置的参数
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));

    }

    /**
     * 给字段添加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            //文档注释开始
            field.addJavaDocLine("/**");
            //获取数据库字段的备注信息
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" * " + remarkLine);
            }
            field.addJavaDocLine(" */");
        }
    }


    /**
     * 为类添加注释
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) { ;
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author wycfight@163.com");
        topLevelClass.addJavaDocLine(" * @description: " + introspectedTable.getRemarks());
        topLevelClass.addJavaDocLine(" * @date " + new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
        topLevelClass.addJavaDocLine(" * @modify By: ");
        topLevelClass.addJavaDocLine(" */");


    }
}
