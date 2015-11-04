package com.heros.doing.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.heros.doing.model.Doing;

public interface DoingService {

	boolean addDoing(Doing doing);

	String[] saveDoingImgs(MultipartHttpServletRequest request, int imgCount);

}
