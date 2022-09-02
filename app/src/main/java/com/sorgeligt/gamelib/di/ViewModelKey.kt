package com.sorgeligt.gamelib.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.PROPERTY_GETTER,
)
@Retention
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
