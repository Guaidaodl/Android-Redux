package me.guaidaodl.andux.counter

import me.guaidaodl.andux.core.Store
import me.guaidaodl.andux.core.createStore


typealias CounterStore = Store<CounterState, CounterAction>

val store: CounterStore = createStore(CounterState(0, 0), { state, action ->
    when (action) {
        FirstIncrement -> state.copy(firstNumber = state.firstNumber + 1)
        FirstDecrement -> state.copy(firstNumber = state.firstNumber - 1)
        SecondIncrement -> state.copy(secondNumber = state.secondNumber + 1)
        SecondDecrement -> state.copy(secondNumber = state.secondNumber - 1)
    }
})
