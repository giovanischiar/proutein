package io.schiar.proutein.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.proutein.model.Food
import io.schiar.proutein.model.repository.FoodRepository
import io.schiar.proutein.model.repository.FoodRepositoryInterface
import io.schiar.proutein.view.viewdata.FoodViewData

class FoodsViewModel(
    private val foodsRepository: FoodRepositoryInterface = FoodRepository()
) : ViewModel() {
    val foods: MutableLiveData<List<FoodViewData>> by lazy {
        MutableLiveData<List<FoodViewData>>()
    }
    val helloWorld = MutableLiveData("Hello World!")

    fun fetch() {
        foodsRepository.fetch {
            foods.postValue(it.map { food ->
                FoodViewData(
                    food.name,
                    listOf(food.serving.toString(), (food.serving / 28.34952).toString()),
                    listOf(food.energy.toString(), (food.energy * 4.184).toString()),
                    food.protein.toString()
                )
            })
        }
    }
}
