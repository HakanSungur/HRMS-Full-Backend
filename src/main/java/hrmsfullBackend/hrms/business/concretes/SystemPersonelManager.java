package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.SystemPersonelService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.SystemPersonelDao;
import hrmsfullBackend.hrms.entities.concretes.SystemPersonel;

@Service
public class SystemPersonelManager implements SystemPersonelService {

	private SystemPersonelDao systemPersonelDao;

	public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
		super();
		this.systemPersonelDao = systemPersonelDao;
	}

	@Override
	public DataResult<List<SystemPersonel>> getSystemPersonels() {
		if((long) this.systemPersonelDao.findAll().size()>0) {
			return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(), "Sistem personelleri listelendi!");
		}else {
			return new ErrorDataResult<List<SystemPersonel>>("Sistem personeli bulunamadı!");
		}
		
	}

	@Override
	public Result addSystemPersonel(SystemPersonel systemPersonel) {
		try {
			this.systemPersonelDao.save(systemPersonel);
		return new SuccessResult("Sistem personeli eklendi!");
		} catch (Exception e) {
			if(e.getMessage().contains("[uc_users_email]")) {
				return new ErrorResult("Email sistemde kayıtlı!");
			}else {
				return new ErrorResult("Kullanıcı adı sistemde kayıtlı!");
			}
			
		}
		
	}

	@Override
	public Result updateSystemPersonel(SystemPersonel systemPersonel) {
		try {
			this.systemPersonelDao.save(systemPersonel);
		return new SuccessResult("Sistem personeli güncellendi!");
		} catch (Exception e) {
			if(e.getMessage().contains("[uc_users_email]")) {
				return new ErrorResult("Email sistemde kayıtlı!");
			}else {
				return new ErrorResult("Kullanıcı adı sistemde kayıtlı!");
			}
			
		}
	}

	@Override
	public DataResult<SystemPersonel> getSystemPersonelById(int id) {
		if(this.systemPersonelDao.getById(id)==null) {
			return new ErrorDataResult<SystemPersonel>("Kayıtlı sistem personeli bulunamadı!");
		}else {
			return new SuccessDataResult<SystemPersonel>(this.systemPersonelDao.getById(id), "Sistem personeli listelendi!");
		}
	}

	@Override
	public Result deleteSystemPersonelById(int id) {
		this.systemPersonelDao.deleteSystemPersonelById(id);
		return new SuccessResult("Sistem personeli silindi!");
	}
	
	
}
