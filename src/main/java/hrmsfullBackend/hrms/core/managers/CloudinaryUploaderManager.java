package hrmsfullBackend.hrms.core.managers;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryUploaderManager {

	Cloudinary cloudinary;
	
	public void CloudinaryManager () {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hsungur",
                "api_key", "",
                "api_secret", ""));
	}
	
	@SuppressWarnings("rawtypes")
	public DataResult<Map> addPicture(MultipartFile pictureFile) throws IOException{
		Map<String, Object> options = new HashMap<>();
        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
        options.put("allowed_formats", allowedFormats);
        File file = convertToFile(pictureFile);
        Map uploader = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
        return new SuccessDataResult<>(uploader);
		
		
	}

	private File convertToFile(MultipartFile pictureFile) throws IOException {
		File file = new File("C:\\Users\\275777\\desktop\\hrms" + pictureFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(pictureFile.getBytes());
        stream.close();
        return file;
	}
	
}
