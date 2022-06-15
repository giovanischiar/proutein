package io.schiar.proutein.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import format
import io.schiar.proutein.model.repository.FoodRepository
import io.schiar.proutein.model.repository.FoodRepositoryInterface
import io.schiar.proutein.view.viewdata.FoodViewData
import toViewData

class FoodsViewModel(
    private val foodsRepository: FoodRepositoryInterface = FoodRepository()
) : ViewModel() {
    val foods: MutableLiveData<List<FoodViewData>> by lazy {
        MutableLiveData<List<FoodViewData>>()
    }

    fun fetch() {
        foodsRepository.fetch {
            foods.postValue(it.map { food ->
                FoodViewData(
                    food.name,
                    food.serving.toViewData(),
                    food.energy.toViewData(),
                    food.protein.format("g")
                )
            })
        }
    }
}
