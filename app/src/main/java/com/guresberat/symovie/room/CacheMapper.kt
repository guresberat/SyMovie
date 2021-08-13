package com.guresberat.symovie.room

import com.guresberat.symovie.domain.model.Movie
import com.guresberat.symovie.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<MovieCacheEntity, Movie> {

    override fun mapFromEntity(entity: MovieCacheEntity): Movie {
        return Movie(
            budget = entity.budget,
            id = entity.id,
            name = entity.name,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            revenue = entity.revenue,
            runtime = entity.runtime,
            status = entity.status,
            tagline = entity.tagline,
            title = entity.title,
            rating = entity.rating,
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieCacheEntity {
        return MovieCacheEntity(
            budget = domainModel.budget,
            id = domainModel.id,
            name = domainModel.name,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            posterPath = domainModel.posterPath,
            releaseDate = domainModel.releaseDate,
            revenue = domainModel.revenue,
            runtime = domainModel.runtime,
            status = domainModel.status,
            tagline = domainModel.tagline,
            title = domainModel.title,
            rating = domainModel.rating,
        )
    }

    fun mapFromEntityList(entities: List<MovieCacheEntity>): List<Movie> {
        return entities.map { mapFromEntity(it) }
    }
}