package com.heros.doing.service.impl;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.heros.doing.constants.ServerConstants;
import com.heros.doing.dao.DoingDao;
import com.heros.doing.model.Doing;
import com.heros.doing.service.DoingService;

@Service
public class DoingServiceImpl implements DoingService{
	private static final Logger logger = LoggerFactory.getLogger(DoingServiceImpl.class);
	@Autowired
	DoingDao doingDao;
	
	@Override
	public boolean addDoing(Doing doing){
		return doingDao.addDoing(doing);
	}
	
	@Override
	public String[] saveDoingImgs(MultipartHttpServletRequest request, int imgCount){
			String fileNamePrefix = "" + System.currentTimeMillis();
			String imgPathList[] = new String[imgCount]; 
			try {
				
				File iconDir = new File(ServerConstants.DOING_IMG_DIR);
				if(!iconDir.exists()){
					iconDir.mkdirs();
				}
				for(int i = 0; i < imgCount; i++){
					MultipartFile imgFile = request.getFile("img" + i);
					if(imgFile == null){
						imgPathList[i] = "";
						continue;
					}
					String fileName = fileNamePrefix + i + ".jpg";
					imgFile.transferTo(new File(ServerConstants.DOING_IMG_DIR + "/" + fileName));
					imgPathList[i] = ServerConstants.DOING_IMG_URL + "/" + fileName;
				}
			} catch (IllegalStateException e) {
				logger.error("saveDoingImgs error1, {}", e);
			} catch (IOException e) {
				logger.error("saveDoingImgs error2, {}", e);
			}
			return imgPathList;
	}
	
}
