package com.xms.test;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.google.gson.Gson;
import com.xms.bean.T_MALL_CLASS_1;
import com.xms.mapper.T_MALL_CLASS_1_mapper;

public class testJunit1 {

	@Test
	public void test() throws IOException {
		
		//获取sqlsessionFactory
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
		//获取session；
		SqlSession session = sqlSessionFactory.openSession();
		
		//获取mapper
		T_MALL_CLASS_1_mapper class_1_mapper = session.getMapper(T_MALL_CLASS_1_mapper.class);
	
		//操作获取数据
		List<T_MALL_CLASS_1> classlist = class_1_mapper.getlist();
		System.out.println(classlist.size());
	   
		//创建gson
		Gson gson = new Gson();
		
		//转json
		String classstr = gson.toJson(classlist);
		
		//生成静态文件
		FileOutputStream fileOutputStream = new FileOutputStream("e:/class_1.js");
		fileOutputStream.write(classstr.getBytes());
		fileOutputStream.close();
	}

}
