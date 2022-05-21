package com.guresberat.symovie.api.util

import com.guresberat.symovie.api.model.MovieNetworkEntity
import com.guresberat.symovie.domain.model.Movie
import com.guresberat.symovie.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<MovieNetworkEntity, Movie> {

    override fun mapFromEntity(entity: MovieNetworkEntity): Movie{
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

    override fun mapToEntity(domainModel: Movie): MovieNetworkEntity {
        return MovieNetworkEntity(
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

    fun mapFromEntityList(entities: List<MovieNetworkEntity>): List<Movie> {
        return entities.map { mapFromEntity(it) }
    }
}
