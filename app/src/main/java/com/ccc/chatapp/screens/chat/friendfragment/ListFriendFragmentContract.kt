package com.ccc.chatapp.screens.chat.friendfragment

import com.ccc.chatapp.screens.BasePresenter

interface ListFriendFragmentview {
    fun updateListFriend()
}

interface ListFriendFragmentPresenter : BasePresenter {
    fun getListFriend()
}