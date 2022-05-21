package com.guresberat.symovie.room

import com.guresberat.symovie.domain.model.Movie
import com.guresberat.symovie.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<MovieCacheEntity, Movie> {

    override fun mapFromEntity(entity: MovieCacheEntity): Movie {
        return Movie(
            id = entity.id,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            backdropPath = entity.backdropPath,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            title = entity.title,
            ratingAverage = entity.ratingAverage,
            rating = entity.rating,
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieCacheEntity {
        return MovieCacheEntity(
            id = domainModel.id,
            originalTitle = domainModel.originalTitle,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            backdropPath = domainModel.backdropPath,
            posterPath = domainModel.posterPath,
            releaseDate = domainModel.releaseDate,
            title = domainModel.title,
            ratingAverage = domainModel.ratingAverage,
            rating = domainModel.rating,
        )
    }

    fun mapFromEntityList(entities: List<MovieCacheEntity>): List<Movie> {
        return entities.map { mapFromEntity(it) }
    }
}