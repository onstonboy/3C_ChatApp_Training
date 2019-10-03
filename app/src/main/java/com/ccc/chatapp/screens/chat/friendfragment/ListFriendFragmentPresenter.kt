package com.ccc.chatapp.screens.chat.friendfragment

import android.view.View
import com.ccc.chatapp.repositories.UserRepository
import com.ccc.chatapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class ListFriendFragmentPresenterImpl(
    private var view: View?,
    private var schedulerProvider: SchedulerProvider,
    private var userRepository: UserRepository
) : ListFriendFragmentPresenter {
    private var mCompositeDisposable = CompositeDisposable()
    override fun getListFriend() {
        val disposable = userRepository
            .getListFriend()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({

            }, {

            }, {

            })
        mCompositeDisposable.add(disposable)
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }

}