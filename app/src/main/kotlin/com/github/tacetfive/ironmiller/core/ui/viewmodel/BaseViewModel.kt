package com.github.tacetfive.ironmiller.core.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.gitverse.olimp.rickandmortyapp.core.ui.utils.UiEvent
import ru.gitverse.olimp.rickandmortyapp.core.ui.utils.UiSideEffect
import ru.gitverse.olimp.rickandmortyapp.core.ui.utils.UiState

abstract class BaseViewModel<State : UiState, Event : UiEvent, SideEffect : UiSideEffect>(
    initialState: State
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState get() = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SideEffect>()
    val sideEffect get() = _sideEffect.asSharedFlow()

    protected fun updateState(function: (state: State) -> State) {
        _uiState.update(function)
    }

    abstract fun handleEvent(event: Event)

    protected fun emitSideEffect(effect: SideEffect) {
        viewModelScope.launch {
            _sideEffect.emit(effect)
        }
    }
}
