package com.muson;
import com.muson.SongsAndGenres.Genre;
import com.muson.SongsAndGenres.GenreDAO;
import com.muson.SongsAndGenres.Song;
import com.muson.SongsAndGenres.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private GenreDAO genreDAO;//performs all DB operations related to table "genres"
    private SongRepo songRepo;//performs all DB operations related to table "songs"

    @GetMapping("/playSong")
    public Song returnSongInfo(@RequestParam(value = "songName", defaultValue = "default song") String songName, @RequestParam(value = "artistName", defaultValue = "default song") String artistName)
    {
        return songRepo.findById((artistName + songName).hashCode());
    }

    @GetMapping("/showAllGenres")
    public List<Genre> showGenres()
    {
        return genreDAO.getAllBy();
    }

    @GetMapping("/showAllSongs")
    public List<Song> show()
    {
        return songRepo.getAllByOrderByIdAsc();
    }



}
