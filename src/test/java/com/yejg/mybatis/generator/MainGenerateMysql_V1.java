package com.yejg.mybatis.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

@SuppressWarnings("unused")
public class MainGenerateMysql_V1 {

	public static void main(String[] args) throws Exception {

		// List<String> warnings = new ArrayList<String>();
		// boolean overwrite = true;
		// ConfigurationParser cp = new ConfigurationParser(warnings);
		//
		// // String configFilePath =
		// "E:/eclipse_workspace/workspace_luna_experiment_branch/mybatis-generator/src/main/resources/generatorConfig.xml";
		// // FileInputStream fis = new FileInputStream(configFilePath);
		// // Configuration config = cp.parseConfiguration(fis);
		//
		// Configuration config =
		// cp.parseConfiguration(MainGenerate_V2.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));
		// DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		// MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
		// callback, warnings);
		// myBatisGenerator.generate(null);
		// System.out.println("----done----");
		try {
			// 用来获取generator.properties文件的配置信息
			final ResourceBundle rb = ResourceBundle.getBundle("generator");
			/* 配置xml配置项 */
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			Configuration config = new Configuration();
			Context context = new Context(ModelType.CONDITIONAL);
			context.setTargetRuntime("MyBatis3Simple");
			context.setId("defaultContext");
			// 自动识别数据库关键字，默认false，如果设置为true，
			// 根据SqlReservedWords中定义的关键字列表；一般保留默认值，遇到数据库关键字（Java关键字），
			// 使用columnOverride覆盖
			context.addProperty("autoDelimitKeywords", "true");
			// 生成的Java文件的编码
			context.addProperty("javaFileEncoding", "utf-8");
			context.addProperty("beginningDelimiter", "`");
			context.addProperty("endingDelimiter", "`");
			// 格式化java代码
			context.addProperty("javaFormatter", "org.mybatis.generator.api.dom.DefaultJavaFormatter");
			// 格式化xml代码
			context.addProperty("xmlFormatter", "org.mybatis.generator.api.dom.DefaultXmlFormatter");

			// 格式化信息
			PluginConfiguration pluginConfiguration = new PluginConfiguration();
			pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
			pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.ToStringPlugin");
			context.addPluginConfiguration(pluginConfiguration);

			// 设置是否生成注释
			CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
			commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
			commentGeneratorConfiguration.addProperty("suppressDate", "true");
			context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

			// 设置连接数据库
			JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
			jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
			jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://localhost:3306/sb_01");
			jdbcConnectionConfiguration.setPassword("root");
			jdbcConnectionConfiguration.setUserId("root");
			context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

			JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
			// 是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.）
			javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");
			context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);

			// 生成实体类的地址
			JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
			javaModelGeneratorConfiguration.setTargetPackage("com.snowy.manager.model");
			javaModelGeneratorConfiguration.setTargetProject("src/main/java");
			javaModelGeneratorConfiguration.addProperty("enableSubPackages", "false");
			javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
			context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

			// 生成的xml的地址
			SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
			sqlMapGeneratorConfiguration.setTargetProject("src/main/resources");
			sqlMapGeneratorConfiguration.setTargetPackage("mappers");
			sqlMapGeneratorConfiguration.addProperty("enableSubPackages", "false");
			context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

			// 生成mapxml对应client，也就是接口dao
			JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
			javaClientGeneratorConfiguration.setTargetPackage("com.snowy.manager.dao");
			javaClientGeneratorConfiguration.setTargetProject("src/main/java");
			javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
			javaClientGeneratorConfiguration.addProperty("enableSubPackages", "false");
			context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

			TableConfiguration tableConfiguration = new TableConfiguration(context);
			tableConfiguration.setTableName("userrole");
			tableConfiguration.setCountByExampleStatementEnabled(true);
			tableConfiguration.setUpdateByExampleStatementEnabled(true);
			tableConfiguration.setDeleteByExampleStatementEnabled(true);
			tableConfiguration.setInsertStatementEnabled(true);
			tableConfiguration.setDeleteByPrimaryKeyStatementEnabled(true);
			tableConfiguration.setSchema("sb_01");
			GeneratedKey generatedKey = new GeneratedKey("id", "MySql", true, null);
			tableConfiguration.setGeneratedKey(generatedKey);
			context.addTableConfiguration(tableConfiguration);

			config.addContext(context);

			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("----done----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
