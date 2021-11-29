package hrmsfullBackend.hrms.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.FavoriteService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Favorite;
import hrmsfullBackend.hrms.entities.dtos.addDtos.FavoriteAddDto;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("/getFavorites")
	public DataResult<List<Favorite>> getFavorites(){
		return this.favoriteService.getFavorites();
	}
	
	@GetMapping("/getFavoritesByJobSeekerId")
	public DataResult<List<Favorite>> getFavoritesByJobSeekerId(@RequestParam int id){
		return this.favoriteService.getFavoriteId(id);
	}
	
	@PostMapping("/addFavorite")
	public Result addFavorite(@RequestParam FavoriteAddDto favorite) {
		return this.favoriteService.addFavorite(favorite);
    }
	
	@DeleteMapping("/deleteFovorite")
	public Result deleteFavorite(@RequestParam int id) {
		return this.favoriteService.deleteFavorite(id);
	}
	
	@DeleteMapping("/deleteFovoriteByJobSeekerIdAndJobAdvertId")
	public Result deleteFovoriteByJobSeekerIdAndJobAdvertId(@RequestParam int jobseekerId, int jobAdvertId) {
		return this.favoriteService.deleteFavoriteByJobSeekerIdAndJobAdvertId(jobseekerId, jobAdvertId);
	}
}
