package me.guaidaodl.andux.core

import androidx.lifecycle.*

/**
 * 跟 Lifecycle 绑定的 Store
 */
interface Store<State, Action> {

    val state: State

    fun dispatch(action: Action)

    // 照抄 LiveData 里的 observer 相关的接口.

    fun observe(owner: LifecycleOwner, observer: Observer<in State>)
    fun observeForever(observer: Observer<in State>)
    fun removeObserver(observer: Observer<in State>)
    fun removeObservers(owner: LifecycleOwner)
}

/**
 * 创建利用 ViewModel 和 LiveData 来实现 Store
 */
fun <State, Action> createStore(initState: State, reducer: (State, Action) -> State): Store<State, Action> {
    return object: Store<State, Action> {
        private val liveState = MutableLiveData(initState)

        override val state: State get() = liveState.value!!

        override fun dispatch(action: Action) {
            val newState = reducer(state, action)
            liveState.value = newState
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<in State>) {
            liveState.observe(owner, observer)
        }

        override fun observeForever(observer: Observer<in State>) {
            liveState.observeForever(observer)
        }

        override fun removeObserver(observer: Observer<in State>) {
            liveState.removeObserver(observer)
        }

        override fun removeObservers(owner: LifecycleOwner) {
            liveState.removeObservers(owner)
        }
    }
}

