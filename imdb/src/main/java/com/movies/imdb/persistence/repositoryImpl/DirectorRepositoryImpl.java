package com.movies.imdb.persistence.repositoryImpl;

import com.movies.imdb.domain.entity.Director;
import com.movies.imdb.domain.repository.DirectorRepository;
import com.movies.imdb.mapper.DirectorMapper;
import com.movies.imdb.persistence.dao.DirectorDAO;
import com.movies.imdb.persistence.model.DirectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DirectorRepositoryImpl implements DirectorRepository {
    @Autowired
    DirectorDAO directorDAO;
    public Optional<Director> getById(Integer id){
        DirectorEntity directorEntity = directorDAO.findById(id).orElse(null);
        return directorEntity != null ? Optional.ofNullable(DirectorMapper.mapper.toDirector(directorEntity)) : Optional.empty();
    }
}
