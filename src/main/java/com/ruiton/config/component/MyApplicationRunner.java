package com.ruiton.config.component;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 启动后运行
 */
@Component
public class MyApplicationRunner implements ApplicationRunner{
	//上转文件根路径
	@Value("${excel.file.uploads.basedir}")
	protected String  excelFileUploadsBasedir;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		File file=new File(excelFileUploadsBasedir);
		if(!file.exists()){
			file.mkdirs();
		}
	}
}
