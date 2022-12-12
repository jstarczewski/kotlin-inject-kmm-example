package com.jstarczewski.kotlininjectkmm

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject

@Inject
class ExampleRepository {

    fun getDummyStrings() = listOf("Dummy", "Strings")
}

class ExampleViewModel @Inject constructor(
    private val exampleRepository: ExampleRepository
) {

    val dummyStringsForUi = exampleRepository.getDummyStrings()
}

@Component
abstract class ExampleComponent {

    abstract val exampleViewModel: ExampleViewModel
}

fun provideViewModel(): ExampleViewModel = ExampleComponent::class.create().exampleViewModel