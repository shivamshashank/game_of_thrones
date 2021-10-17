package com.brighter_bee.tech.game_of_thrones.di

import com.brighter_bee.tech.game_of_thrones.core.Constants
import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.CharacterApi
import com.brighter_bee.tech.game_of_thrones.features.character.data.repository.CharacterRepositoryImpl
import com.brighter_bee.tech.game_of_thrones.features.character.domain.repository.CharacterRepository
import com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.RandomQuoteApi
import com.brighter_bee.tech.game_of_thrones.features.home.data.remote.repository.RandomQuoteRepositoryImpl
import com.brighter_bee.tech.game_of_thrones.features.home.domain.repository.RandomQuoteRepository
import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.HouseApi
import com.brighter_bee.tech.game_of_thrones.features.house.data.repository.HouseRepositoryImpl
import com.brighter_bee.tech.game_of_thrones.features.house.domain.repository.HouseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHouseApi(): HouseApi{
        return Retrofit.Builder()
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HouseApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHouseRepository(houseApi: HouseApi): HouseRepository{
        return HouseRepositoryImpl(houseApi)
    }

    @Provides
    @Singleton
    fun provideRandomQuoteApi(): RandomQuoteApi{
        return Retrofit.Builder()
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomQuoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRandomQuoteRepository(randomQuoteApi: RandomQuoteApi): RandomQuoteRepository{
        return RandomQuoteRepositoryImpl(randomQuoteApi)
    }

    @Provides
    @Singleton
    fun provideCharacterApi(): CharacterApi{
        return Retrofit.Builder()
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(characterApi: CharacterApi): CharacterRepository{
        return CharacterRepositoryImpl(characterApi)
    }

}