package hrmsfullBackend.hrms.core.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<Map> addPicture(MultipartFile pictureFile)throws IOException;
}
