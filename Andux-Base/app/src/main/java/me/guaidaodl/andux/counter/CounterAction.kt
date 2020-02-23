package me.guaidaodl.andux.counter

sealed class CounterAction

object FirstIncrement: CounterAction()

object FirstDecrement: CounterAction()

object SecondIncrement: CounterAction()

object SecondDecrement: CounterAction()

