package com.ccc.chatapp.screens.chat.friendfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccc.chatapp.Application
import com.ccc.chatapp.R
import com.ccc.chatapp.data.model.User
import com.ccc.chatapp.repositories.UserRepository
import com.ccc.chatapp.screens.chat.ItemClickListener
import com.ccc.chatapp.utils.rx.SchedulerProvider
import kotlinx.android.synthetic.main.fragment_account.*
import javax.inject.Inject

class ListFriendFragment(listFriend: ArrayList<User>) : Fragment(), ListFriendFragmentview,
    ItemClickListener {

    @Inject
    lateinit var mSchedulerProvider: SchedulerProvider
    @Inject
    lateinit var mUserRepository: UserRepository

    private lateinit var mPresenter: ListFriendFragmentPresenterImpl
    private var mListFriend = listFriend

    override fun updateListFriend() {
    }

    override fun onClick(view: View?, position: Int) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as Application).getAppComponent().inject(this)
        mPresenter = ListFriendFragmentPresenterImpl(this.view, mSchedulerProvider, mUserRepository)
        val adapter = context?.let {
            AdapterFriendList(
                it, mListFriend
            )
        }
        friendRecyclerView.adapter = adapter
        friendRecyclerView.layoutManager = LinearLayoutManager(context)
        friendRecyclerView.setHasFixedSize(true)
        friendRecyclerView.itemAnimator = DefaultItemAnimator()
        adapter?.setItemClickListener(this)
        return inflater.inflate(R.layout.fragment_account, container)
    }

    companion object {
        fun newInstance(listFriend: ArrayList<User>): ListFriendFragment {
            return ListFriendFragment(listFriend = listFriend)
        }
    }
}