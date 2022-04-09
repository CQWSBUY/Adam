package com.adam.basicAuth;

import com.adam.common.entity.BaseEntity;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: adam 系统 account 模块 代码生成器
 * @date 2021/12/28 9:42
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir")+"/adam-account";
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/adam?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8", "root", "Moky1993@")
                .globalConfig(builder -> {
                    builder.author("Moky") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.adam") // 设置父包名
                            .moduleName("account") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\my_project\\Adam\\adam-account\\src\\main\\resources\\mybatis.mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    //builder.addInclude("adam_account"); // 设置需要生成的表名
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                    builder.entityBuilder().superClass(com.adam.common.entity.BaseEntity.class);
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
