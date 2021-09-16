package hrmsfullBackend.hrms.core.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.core.managers.CloudinaryUploaderManager;
import hrmsfullBackend.hrms.core.services.CloudinaryService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;

@Service
public class CloudinaryUploaderManagerAdapter implements CloudinaryService {

	private CloudinaryUploaderManager cloudinaryUploaderManager;

	public CloudinaryUploaderManagerAdapter(CloudinaryUploaderManager cloudinaryUploaderManager) {
		super();
		this.cloudinaryUploaderManager = cloudinaryUploaderManager;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> addPicture(MultipartFile pictureFile) throws IOException {
		return this.cloudinaryUploaderManager.addPicture(pictureFile);
	}
	
	
}
